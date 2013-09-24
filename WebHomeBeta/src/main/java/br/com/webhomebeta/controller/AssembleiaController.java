package br.com.webhomebeta.controller;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.UploadArquivosAssembleiaControllerBean;
import br.com.webhomebeta.entity.Assembleia;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.AssembleiaService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.validacao.ValidadorAssembleia;

@Controller
public class AssembleiaController {
	@Autowired
	private ServletContext context;
	@Autowired
	private AssembleiaService assembleiaService;
	private Assembleia assembleia;
	private UploadArquivosAssembleiaControllerBean beanUsuarios;
	@Autowired
	private UsuarioService usuarioService;

	private ValidadorAssembleia validadorAssembleia = new ValidadorAssembleia();

	// mapeia a URL principal (Assembleia) e retorna um novo objeto assembleia
	@RequestMapping(value = "inserirAssembleia", method = RequestMethod.GET)
	public ModelAndView InserirAssembleia(ModelMap model) {
		List<Assembleia> assembleias = assembleiaService.getList();
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				beanUsuarios.setUsuario(usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername()));

			}
		}

		model.put("listaAssembleia", assembleias);
		model.put("ArquivosAssembleia", beanUsuarios);
		model.put("assembleia", new UploadArquivosAssembleiaControllerBean());
		// Retorna a pagina inserirAssembleia.jsp com uma Assembleia criado
		return new ModelAndView("assembleia", model);
	}

	@RequestMapping(value = "Assembleia/addArquivos", method = RequestMethod.POST)
	// valor da action
	public ModelAndView AssembleiaArquivos(
			@ModelAttribute("assembleia") final UploadArquivosAssembleiaControllerBean bean,
			BindingResult result, HttpServletRequest request) throws Exception {
		SecurityContext context = SecurityContextHolder.getContext();
		salvar(bean.getFileData(), assembleia, beanUsuarios.getUsuario(),bean);
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				beanUsuarios.setUsuario(usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername()));

			}
		}
		return new ModelAndView("uploadArquivo", "assembleia", bean);
	}

	private void salvar(MultipartFile file, Assembleia assembleia,
			Usuario usuario,UploadArquivosAssembleiaControllerBean bean) throws Exception {
		File fileToDisk = null;
		File caminho = null;

		String caminhoPasta = this.context.getRealPath("")
				+ "/uploadedArquivosAssembleia/" + usuario.getIdUser();

		String result = this.context.getRealPath("")
				+ "/uploadedArquivosAssembleia/" + usuario.getIdUser() + "/"
				+ file.getOriginalFilename();
		try {

			if (file.getOriginalFilename().endsWith("pdf")) {
				caminho = new File(caminhoPasta);

				fileToDisk = new File(result);

				if (!caminho.isDirectory()) {
					caminho.mkdirs();
				}

				file.transferTo(fileToDisk);

			}

			assembleia = new Assembleia();
			usuario.setNome(result);
			assembleia.setArquivo("/WebHomeBeta/uploadedArquivosAssembleia/"
					+ usuario.getIdUser() + "/" + file.getOriginalFilename());
			assembleia.setAssembleia(bean.getAssembleiaTO().getAssembleia());
			assembleia.setDataAssembleia((Date) bean.getAssembleiaTO().getDataAssembleia());
			assembleia.setDataCriacao((Date) bean.getAssembleiaTO().getDataCriacao());
			assembleia.setTitulo(bean.getAssembleiaTO().getTitulo());
			assembleia.setUsuarioAssebleia(bean.getAssembleiaTO().getUsuarioAssebleia());
			assembleiaService.save(assembleia);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "addAssembleia", method = RequestMethod.POST)
	// valor da action
	public ModelAndView Atas(
			@ModelAttribute("assembleia") final UploadArquivosAssembleiaControllerBean AssembleiaBean,
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
			UploadArquivosAssembleiaControllerBean assembleiaControllerBean) {

		if (!validadorAssembleia.isValidAssembleia(assembleiaControllerBean
				.getAssembleiaTO().getAssembleia()));
			;
		{
			assembleiaControllerBean.isAssembleia(false);

		}
		assembleiaControllerBean.isAssembleia(true);
	}

	@RequestMapping(value = "assembelia/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("idAssembleia") int id,
			BindingResult result, HttpServletRequest request) {
		Assembleia descricaoAssembleia = assembleiaService.editar(id);
		return new ModelAndView("inserirAtas/editar", "assembleia",
				descricaoAssembleia);

	}

	@RequestMapping(value = "assembelia/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("assembleia") Assembleia assembleia,
			BindingResult result) {

		assembleiaService.update(assembleia);

		return "redirect:/inserirAssembleia/editar";

	}

	@RequestMapping(value = "assembelia/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("assembleia") Assembleia assembleia,
			BindingResult result) {
		assembleiaService.delete(assembleia);

		return "redirect:/inserirAssembleia/delete";
	}

}
