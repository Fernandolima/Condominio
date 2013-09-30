package br.com.webhomebeta.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.MetaValue;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.PerfilControllerBean;
import br.com.webhomebeta.entity.FileData;
import br.com.webhomebeta.entity.Perfil;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.PerfilService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.PerfilTO;

@Controller
public class PerfilController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PerfilControllerBean perfilControllerBean;
	@Autowired
	private PerfilService perfilService;

	private FileData fileData;

	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public ModelAndView visualizarPerfil(ModelMap model) {

		if (getPerfilTO() == null)
			model.put("perfilControllerBean", perfilControllerBean);
		else {
			perfilControllerBean.setPerfilTO(getPerfilTO());
			model.put("perfilControllerBean", perfilControllerBean);
		}

		return new ModelAndView("perfil", model);
	}

	@RequestMapping(value = "perfil/upload", method = RequestMethod.POST)
	public @ResponseBody
	LinkedList<FileData> uploadFoto(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		// Recebe cada arquivo
		while (itr.hasNext()) {

			// Pega o proximo MultipartFile
			mpf = request.getFile(itr.next());
			System.out.println(mpf.getOriginalFilename() + " uploaded! "
					+ perfilControllerBean.getFiles().size());

			// Se a quantidade de arquivos for > 10 remove o primeiro da lista
			if (perfilControllerBean.getFiles().size() >= 10)
				perfilControllerBean.getFiles().pop();

			fileData = new FileData();
			fileData.setFileName(mpf.getOriginalFilename());
			fileData.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileData.setFileType(mpf.getContentType());

			try {
				fileData.setBytes(mpf.getBytes());
				
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
						"C:/imgs/" + mpf.getOriginalFilename()));

			} catch (IOException e) {

				e.printStackTrace();
			}
			// Adiciona o arquivo para a lista
			perfilControllerBean.getFiles().add(fileData);
		}
		return perfilControllerBean.getFiles();
	}

	@RequestMapping(value = "perfil/get/{value}", method = RequestMethod.GET)
	public void get(HttpServletResponse response,
			@PathVariable("value") String value) {
		FileData getFile = perfilControllerBean.getFiles().get(
				Integer.parseInt(value));
		try {
			response.setContentType(getFile.getFileType());
			response.setHeader("Content-disposition", "attachment; filename=\""
					+ getFile.getFileName() + "\"");
			FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(value = "perfil/editar", method = RequestMethod.POST)
	public void editarSobre() {

	}

	@RequestMapping(value = "perfil/salvar", method = RequestMethod.POST)
	public void salvarPerfil(
			@ModelAttribute("perfilControllerBean") PerfilControllerBean bean,
			BindingResult bindingResult) {
		PerfilTO perfilTO = bean.getPerfilTO();
		Perfil perfil = null;
		BeanUtils.copyProperties(perfilTO, perfil);
		perfilService.salvar(perfil);

	}

	public PerfilTO getPerfilTO() {

		Perfil p = perfilService.get(getUsuario().getIdUser());
		if (p == null)
			return null;
		else {
			PerfilTO pTO = new PerfilTO();
			BeanUtils.copyProperties(p, pTO);
			return pTO;
		}

	}

	public Usuario getUsuario() {

		Usuario usuario = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				usuario = usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername());

			}
		}

		return usuario;
	}
}
