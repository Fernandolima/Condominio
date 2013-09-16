package br.com.webhomebeta.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;

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
import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class UploadImageController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private ServletContext context;
	@Autowired
	private UploadControllerBean beanUsuario;

	private void salvar(MultipartFile file, Usuario usuario) throws Exception {
		File fileToDisk = null;
		File fileToDiskRedimensionada = null;
		File caminho = null;

		String caminhoPasta = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser();

		String result = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();

		String resultRedimensionada = this.context.getRealPath("")
				+ "/uploadedImgs/" + usuario.getIdUser() + "/Redimensionada "
				+ file.getOriginalFilename();
		try {

			InputStream stream = new ByteArrayInputStream(file.getBytes());

			// redimensiona imagem para o tamanho 240x240
			BufferedImage bufferImage = ImageIO.read(stream);
			BufferedImage imagemRedimensionada = Scalr.resize(bufferImage,
					Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, 240, 240,
					Scalr.OP_ANTIALIAS);
			if (file.getOriginalFilename().endsWith("jpg")) {
				caminho = new File(caminhoPasta);

				fileToDisk = new File(result);

				if (!caminho.isDirectory()) {
					caminho.mkdir();
				}
				ImageIO.write(imagemRedimensionada, "JPEG", fileToDisk);
			}

			if (file.getOriginalFilename().endsWith("png")) {
				caminho = new File(caminhoPasta);

				fileToDisk = new File(result);

				if (!caminho.isDirectory()) {
					caminho.mkdir();
				}
				ImageIO.write(imagemRedimensionada, "png", fileToDisk);
			}

			usuario.setImagem(result);
			usuario.setImagemView("/WebHomeBeta/uploadedImgs/"
					+ usuario.getIdUser() + "/" + file.getOriginalFilename());
			usuarioService.update(usuario);

			// redimensiona imagem para o tamanho para 43x43
			InputStream stream2 = new ByteArrayInputStream(file.getBytes());
			BufferedImage bufferImage2 = ImageIO.read(stream2);
			BufferedImage imagemRedimensionada43x43 = Scalr.resize(
					bufferImage2, Scalr.Method.ULTRA_QUALITY,
					Scalr.Mode.FIT_EXACT, 43, 43, Scalr.OP_ANTIALIAS);
			if (file.getOriginalFilename().endsWith("jpg")) {
				fileToDiskRedimensionada = new File(resultRedimensionada);
				ImageIO.write(imagemRedimensionada43x43, "JPEG",
						fileToDiskRedimensionada);
			}
			if (file.getOriginalFilename().endsWith("png")) {
				fileToDiskRedimensionada = new File(resultRedimensionada);
				ImageIO.write(imagemRedimensionada43x43, "PNG",
						fileToDiskRedimensionada);
			}

			publicacaoService.update(usuario.getIdUser(),
					"/WebHomeBeta/uploadedImgs/" + usuario.getIdUser()
							+ "/Redimensionada " + file.getOriginalFilename());
			comentarioService.update(usuario.getIdUser(),
					"/WebHomeBeta/uploadedImgs/" + usuario.getIdUser()
							+ "/Redimensionada " + file.getOriginalFilename());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "uploadImage", method = RequestMethod.GET)
	public ModelAndView showForm() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				beanUsuario.setUsuario(usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername()));

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
