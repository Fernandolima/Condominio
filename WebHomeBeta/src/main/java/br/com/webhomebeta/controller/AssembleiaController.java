package br.com.webhomebeta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Assembleia;
import br.com.webhomebeta.service.AssembleiaService;
import br.com.webhomebeta.validacao.ValidadorAssembleia;

@Controller
@SessionAttributes("usuarioNaSessao")
public class AssembleiaController {
	@Autowired
	private AssembleiaService assembleiaService;

	private Assembleia assembleia;

	private ValidadorAssembleia validadorAssembleia;

	// mapeia a URL principal (Assembleia) e retorna um novo objeto assembleia
	@RequestMapping(value = "inserirAssembleia", method = RequestMethod.GET)
	public ModelAndView InserirAssembleia(ModelMap model) {
		List<Assembleia> assembleias = assembleiaService.getList();
		model.put("listaAssembleia", assembleias);
		model.put("assembleia", new AssembleiaController());
		// Retorna a pagina inserirAssembleia.jsp com uma  Assembleia criado
		return new ModelAndView("inserirAssembleia", model);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "addAssembleia", method = RequestMethod.POST)
	// valor da action
	public ModelAndView Atas(
			@ModelAttribute("assembleia") final AssembleiaControllerBean AssembleiaBean,
			BindingResult result, HttpServletRequest request) {
		ValidadorAssembleia(AssembleiaBean);
		if (AssembleiaBean.hasErrors()) {

			// cria um objeto de Assembleia, compara com o dados to TO e salva
			// no
			// banco.
			Assembleia descricaoAssembleia = new Assembleia();
			BeanUtils.copyProperties(AssembleiaBean.getAssembleiaTO(),
					descricaoAssembleia);
			// Salva no banco

			assembleiaService.save(descricaoAssembleia);

			return new ModelAndView("inserirAssembleia");
		}

		return new ModelAndView("inserirAssembleia", "assembleia",
				AssembleiaBean);
	}

	public void ValidadorAssembleia(
			AssembleiaControllerBean assembleiaControllerBean) {

		if (!validadorAssembleia.isValidAssembleia(assembleiaControllerBean
				.getAssembleiaTO().getAssembleia()))
			;
		{
			assembleiaControllerBean.isAssembleia(false);

		}
		assembleiaControllerBean.isAssembleia(true);
	}

	@RequestMapping(value = "editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("idAssembleia") int id,
			BindingResult result, HttpServletRequest request) {
		Assembleia descricaoAssembleia = assembleiaService.editar(id);
		return new ModelAndView("inserirAtas/editar", "atas",
				descricaoAssembleia);

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("assembleia") Assembleia assembleia,
			BindingResult result) {

		assembleiaService.update(assembleia);

		return "redirect:/inserirAssembleia/editar";

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("assembleia") Assembleia assembleia,
			BindingResult result) {
		assembleiaService.delete(assembleia);

		return "redirect:/inserirAssembleia/editar";
	}

}
