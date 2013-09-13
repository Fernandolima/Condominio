package br.com.webhomebeta.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.UploadControllerBean;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class UploadImageController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ServletContext context;
	@Autowired
	private UploadControllerBean beanUsuario;
	
	private void salvar(MultipartFile file, Usuario usuario) throws Exception {
		String result = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();
		try {
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				outputStream = new FileOutputStream(result);
				System.out.println(file.getOriginalFilename());
				System.out.println("Arquivo salvo no disco rigido.");
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		usuario.setImagem(result);
		usuario.setImagemView("/WebHomeBeta/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename());
		usuarioService.update(usuario);

	}

	@RequestMapping(value = "uploadImage", method = RequestMethod.GET)
	public ModelAndView showForm() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			//Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				//Pega o usuario que logou
				beanUsuario.setUsuario(usuarioService.getUsuarioByLogin(((UserDetailsImp) authentication.getPrincipal()).getUsername()));

			}
		}
		return new ModelAndView("uploadImage", "uploadControllerBean",
				beanUsuario);
	}

	@Async
	@RequestMapping(value = "uploadImage/upload", method = RequestMethod.POST)
	public String upload(
			@ModelAttribute("uploadControllerBean") UploadControllerBean uploadControllerBean,
			BindingResult result) {

		MultipartFile file = uploadControllerBean.getFileData();
		try {
			salvar(file, beanUsuario.getUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/uploadImage";
	}
}
