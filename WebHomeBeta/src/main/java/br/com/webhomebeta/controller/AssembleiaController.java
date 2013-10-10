package br.com.webhomebeta.controller;

import java.io.File;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.UploadArquivosAssembleiaControllerBean;
import br.com.webhomebeta.entity.Assembleia;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.AssembleiaService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.AssembleiaTO;
import br.com.webhomebeta.validacao.ValidadorAssembleia;

@Controller
public class AssembleiaController {
	@Autowired
	private ServletContext context;
	@Autowired
	private AssembleiaService assembleiaService;
	private Assembleia assembleia;
	@Autowired
	private UploadArquivosAssembleiaControllerBean uploadArquivosAssembleiaControllerBean;
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
				uploadArquivosAssembleiaControllerBean
						.setUsuario(usuarioService
								.getUsuarioByLogin(((UserDetailsImp) authentication
										.getPrincipal()).getUsername()));

			}
		}

		model.put("listaAssembleia", assembleias);
		model.put("bean", new UploadArquivosAssembleiaControllerBean());
		// Retorna a pagina inserirAssembleia.jsp com uma Assembleia criado
		return new ModelAndView("assembleia", model);

	}

	@RequestMapping(value = "Assembleia/addArquivos", method = RequestMethod.POST)
	// valor da action
	public String AssembleiaArquivos(
			@ModelAttribute("bean") final UploadArquivosAssembleiaControllerBean bean,
			BindingResult result, HttpServletRequest request) throws Exception {
		SecurityContext context = SecurityContextHolder.getContext();
		ValidadorAssembleia(bean);
		if (bean.hasErrors()) {
			salvar(bean.getFileData(), assembleia,
					uploadArquivosAssembleiaControllerBean.getUsuario(), bean);
		}
		uploadArquivosAssembleiaControllerBean = bean;
		return "redirect:/assembleia";
	}

	private void salvar(MultipartFile file, Assembleia assembleia,
			Usuario usuario, UploadArquivosAssembleiaControllerBean bean)
			throws Exception {
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
			assembleia.setAssembleia(bean.getAssembleiaTO().getAssembleia());
			assembleia.setDataAssembleia((Date) bean.getAssembleiaTO()
					.getDataAssembleia());
			assembleia.setDataCriacao(new Date(0));
			assembleia.setTitulo(bean.getAssembleiaTO().getTitulo());
			assembleia.setUsuarioAssebleia(bean.getAssembleiaTO()
					.getUsuarioAssebleia());
			//assembleiaService.getList();

			AssembleiaTO assembleiaTO = new AssembleiaTO();

			assembleiaTO.setAssembleia(null);
			assembleiaTO.setDataAssembleia(null);
			assembleiaTO.setDataCriacao(null);
			assembleiaTO.setTitulo(null);
			assembleiaService.save(assembleia);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ValidadorAssembleia(UploadArquivosAssembleiaControllerBean bean) {

		if (!validadorAssembleia.isValidAssembleia(bean.getAssembleiaTO()
				.getAssembleia())) {
			bean.setAssembleia(false);

		} else {
			bean.setAssembleia(true);
		}

		if (!validadorAssembleia.isValiTitulo(bean.getAssembleiaTO()
				.getTitulo())) {
			bean.setTitulo(false);
		} else {
			bean.setTitulo(true);
		}
		if (!validadorAssembleia.validaData(bean.getData())) {
			bean.setValidDate(false);

		} else {
			bean.setValidDate(true);
		}
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
