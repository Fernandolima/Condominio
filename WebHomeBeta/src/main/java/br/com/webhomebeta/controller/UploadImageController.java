package br.com.webhomebeta.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.UploadImage;
import br.com.webhomebeta.entity.Usuario;

@Controller
@SessionAttributes("usuarioNaSessao")
public class UploadImageController extends AuthenticatedController{

	private Usuario usuarioNaSessao;
	
	@RequestMapping(value = "uploadImage", method = RequestMethod.GET)
	public ModelAndView showForm(ModelMap model) {
		
		usuarioNaSessao = obterUsuarioLogado();
		model.put("usuarioNaSessao", usuarioNaSessao);
		model.put("uploadImage", new UploadImage());
		
		return new ModelAndView("uploadImage");
	}

	@RequestMapping(value = "uploadImage/upload", method = RequestMethod.POST)
	public String upload(@ModelAttribute("uploadImage") UploadImage image,
			BindingResult result) {
		
		try {

			MultipartFile file = image.getFileData();
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				outputStream = new FileOutputStream("C:\\imgs\\"
						+ file.getOriginalFilename());
				System.out.println(file.getOriginalFilename());
				System.out.println("Arquivo salvo no disco rigido.");
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					System.out.println("....");
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/uploadImage";
	}
}
