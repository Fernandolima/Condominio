package br.com.webhomebeta.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

import com.sun.mail.handlers.image_jpeg;

import br.com.webhomebeta.bean.UploadControllerBean;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PerfilService;
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
	private PerfilService perfilService;
	@Autowired
	private ServletContext context;
	@Autowired
	private UploadControllerBean beanUsuario;

	private void salvar(MultipartFile file, Usuario usuario, int x, int y, int w, int h) throws Exception {
		File fileToDisk = null;
		File fileToDiskRedimensionada = null;
		File caminho = null;

		String caminhoPasta = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser();

		String result = this.context.getRealPath("") + "/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();

		String resultRedimensionada = this.context.getRealPath("")
				+ "/uploadedImgs/" + usuario.getIdUser() + "/r-"
				+ file.getOriginalFilename();
		
		String imagem = "/WebHomeBeta/uploadedImgs/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();
		String imagem43x43 = "/WebHomeBeta/uploadedImgs/"
				+ usuario.getIdUser() + "/r-" + file.getOriginalFilename();
		
		BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
		BufferedImage cropedImage = originalImage.getSubimage(x, y, w, h);
		
		try {
			
			
			caminho = new File(caminhoPasta);
			if(!caminho.isDirectory()){
				caminho.mkdirs();
			}
			
			//salva imagem cropada
			
			if (file.getOriginalFilename().endsWith("jpg")) {
				fileToDisk = new File(result);
				ImageIO.write(cropedImage, "JPEG",
						fileToDisk);
			}
			if (file.getOriginalFilename().endsWith("png")) {
				fileToDisk = new File(result);
				ImageIO.write(cropedImage, "PNG",
						fileToDisk);
			}
			
			usuario.setImagem(imagem);
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

			publicacaoService.update(usuario.getIdUser(), imagem43x43);

			comentarioService.update(usuario.getIdUser(), imagem43x43);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "uploadImage", method = RequestMethod.GET)
	public ModelAndView showForm() {
		beanUsuario.setUsuario(getUsuario());
		return new ModelAndView("uploadImage", "uploadControllerBean",
				beanUsuario);
	}

	@RequestMapping(value = "multiPartFileSingle", method = RequestMethod.POST)
	public void uploadFile(HttpServletResponse response,
			@RequestParam(value = "file") MultipartFile file) {

		String back = "";
		try {
			if (!file.isEmpty()) {

				file.getBytes();
				back = "{successMessage : 'successMessage'}";
			} else {
				back = "{errorMessage : 'errorMessage'}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			back = "{errorMessage : 'errorMessage'}";
		}

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		try {// Changing to ISO, because standard AJAX response is in ISO and
				// our string is in UTF-8
			back = new String(back.getBytes("UTF-8"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// Write Json string in Json format
		AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();
		MediaType jsonMimeType = MediaType.APPLICATION_JSON;
		if (stringHttpMessageConverter.canWrite(String.class, jsonMimeType)) {
			try {
				stringHttpMessageConverter.write(back, jsonMimeType,
						new ServletServerHttpResponse(response));
			} catch (IOException m_Ioe) {
				m_Ioe.printStackTrace();
			} catch (HttpMessageNotWritableException p_Nwe) {
				p_Nwe.printStackTrace();
			}
		}
	}

	@Async
	@RequestMapping(value = "uploadImage/upload", method = RequestMethod.POST)
	public String upload(
			@ModelAttribute("uploadControllerBean") UploadControllerBean uploadControllerBean,
			BindingResult result) {
		int x=370,y=370,w=240,h=240;
		MultipartFile file = uploadControllerBean.getFileData();
		try {
			salvar(file, beanUsuario.getUsuario(),x,y,w,h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/uploadImage";
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
