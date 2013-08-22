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

import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.DescricaoCondominio;
import br.com.webhomebeta.service.AtasService;
import br.com.webhomebeta.to.AtasTo;
import br.com.webhomebeta.validacao.ValidadorAtas;

@Controller
@SessionAttributes("usuarioNaSessao")
public class AtasController {
	@Autowired
	private AtasService atasService;

	private AtasEntity atasEntity;

	private ValidadorAtas validadorAtas;

	private AtasTo atasTo;

	// mapeia a URL principal (Atas) e retorna um novo objeto atas
	@RequestMapping(value = "inserirAtas", method = RequestMethod.GET)
	public ModelAndView InserirAtas(ModelMap model) {
		List<AtasEntity> atas = atasService.getList();
		model.put("listaBlocos", atas);
		model.put("atas", new AtasControllerBean());
		// Retorna a pagina inserirAtas.jsp com uma ata criado
		return new ModelAndView("inserirAtas", model);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "addAtas", method = RequestMethod.POST)
	// valor da action
	public ModelAndView Atas(
			@ModelAttribute("atas") final AtasControllerBean AtasBean,
			BindingResult result, HttpServletRequest request) {
		ValidadorAtas(AtasBean);
		if (AtasBean.hasErrors()) {

			// cria um objeto de AtasEntity, compara com o dados to TO e salva
			// no
			// banco.
			AtasEntity descricao = new AtasEntity();
			BeanUtils.copyProperties(AtasBean.getAtasTo(), descricao);
			// Salva no banco

			atasService.save(descricao);

			return new ModelAndView("inserirAtas");
		}

		return new ModelAndView("inserirAtas", "atas", AtasBean);
	}

	public void ValidadorAtas(AtasControllerBean atasBean) {

		if (!validadorAtas.isValidAtas(atasBean.getAtasTo().getAtas()))
			;
		{
			atasBean.isAtas(false);

		}
		atasBean.isAtas(true);
	}

	@RequestMapping(value = "editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("idAta") int id,
			BindingResult result, HttpServletRequest request) {
		AtasEntity descricaoAtas = atasService.editar(id);
		return new ModelAndView("inserirAtas/editar", "atas", atasEntity);

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("atas") AtasEntity atasEntity,
			BindingResult result) {

		atasService.update(atasEntity);

		return "redirect:/inserirAtas/editar";

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("atas") AtasEntity atasEntity,
			BindingResult result) {
		atasService.delete(atasEntity);

		return "redirect:/inserirAtas/editar";
	}
}
