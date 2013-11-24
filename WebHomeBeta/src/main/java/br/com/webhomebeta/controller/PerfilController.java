package br.com.webhomebeta.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.PerfilControllerBean;
import br.com.webhomebeta.bean.UploadControllerBean;
import br.com.webhomebeta.entity.FileData;
import br.com.webhomebeta.entity.ImagePathAndSize;
import br.com.webhomebeta.entity.Perfil;
import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.handler.ImageHandler;
import br.com.webhomebeta.json.PerfilJSON;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PerfilService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.PerfilTO;
//Controle do perfi;
@Controller
public class PerfilController {

	@Autowired
	private ServletContext context;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PerfilControllerBean perfilControllerBean;
	@Autowired
	private PerfilService perfilService;
	@Autowired
	private UploadControllerBean uploadControllerBean;
	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private ImageHandler imageHandler;

	private FileData fileData;

	@RequestMapping(value = "home/perfil", method = RequestMethod.GET)
	public ModelAndView visualizarPerfil(ModelMap model) {

		if (getPerfilTO() == null) {
			Usuario u = getUsuario();
			List<Publicacao> publicacoes = publicacaoService.getPublicacao(u.getIdUser());
			model.put("perfilControllerBean", perfilControllerBean);
			model.put("uploadControllerBean", uploadControllerBean);
			model.put("publicacoes", publicacoes);
			model.put("usuario", u);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			PerfilJSON perfil = new PerfilJSON();
			perfil.setEmail(u.getEmail());
			perfil.setData(df.format(u.getDt_nascimento()));
			
			Perfil p = perfilService.getByUser(u.getIdUser());
			
			
			perfilControllerBean.setPerfilTO(getPerfilTO());
			
			perfil.setEstilosMusicais(p.getEstilosMusicais());
			perfil.setIdade(p.getIdade());
			perfil.setIdPerfil(p.getIdPerfil());
			perfil.setIdUser(p.getIdUser());
			perfil.setImagemUsuario(p.getImagemUsuario());
			perfil.setLivros(p.getLivros());
			perfil.setNomeUsuario(u.getNome());
			perfil.setSobreMim(p.getSobreMim());
			model.put("perfil", perfil);
			
		} else {
			Usuario u = getUsuario();
			perfilControllerBean.setPerfilTO(getPerfilTO());
			List<Publicacao> publicacoes = publicacaoService.getPublicacao(u.getIdUser());
			model.put("perfilControllerBean", perfilControllerBean);
			model.put("uploadControllerBean", uploadControllerBean);
			model.put("publicacoes", publicacoes);
			model.put("usuario", u);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			PerfilJSON perfil = new PerfilJSON();
			perfil.setEmail(u.getEmail());
			perfil.setData(df.format(u.getDt_nascimento()));
			
			Perfil p = perfilService.getByUser(u.getIdUser());
			
			perfil.setEstilosMusicais(p.getEstilosMusicais());
			perfil.setIdade(p.getIdade());
			perfil.setIdPerfil(p.getIdPerfil());
			perfil.setIdUser(p.getIdUser());
			perfil.setImagemUsuario(p.getImagemUsuario());
			perfil.setLivros(p.getLivros());
			perfil.setNomeUsuario(u.getNome());
			perfil.setSobreMim(p.getSobreMim());
			model.put("perfil", perfil);
		}

		return new ModelAndView("perfil", model);
	}

	
	@RequestMapping(value = "perfil/alterarSenha", method = RequestMethod.POST)
	public @ResponseBody String alterarSenha(
			@ModelAttribute("perfilControllerBean") PerfilControllerBean bean,
			BindingResult result) {

		if (getUsuario().getSenha().equals(bean.getSenha())) {
			if (bean.getNovaSenha().equals(bean.getConfNovaSenha())) {
				usuarioService.update(getUsuario().getIdUser(),
						bean.getNovaSenha());
				return "true";
			} else {
				return "senhaNaoConfere";
			}
		} else {
			return "senhaAtualInvalida";
		}
	}

	// Upload do PERFIL
	@RequestMapping(value = "perfil/upload", method = RequestMethod.POST)
	public @ResponseBody
	ImagePathAndSize upload(
			@ModelAttribute("uploadControllerBean") UploadControllerBean uploadControllerBean,
			BindingResult result) {
		String caminho = null;
		// usado para passar o MultipartFIle para o metodo crop
		this.uploadControllerBean = uploadControllerBean;

		MultipartFile file = uploadControllerBean.getFileData();
		ImagePathAndSize ipz = imageHandler.getOriginalImagemResized(file,
				getUsuario());
		
		System.out.println("aadssdsdaUHADUIDHUDAUHIUA" + ipz.getUrl() + ipz.getHeight());
		
		return ipz;
	}

	@RequestMapping(value = "/perfil/id={id}")
	public ModelAndView visualizarPerfilUsuario(@PathVariable("id") int id, ModelMap model) {
		if (id > 0) {
			model.put("usuario", getUsuario());
			Perfil p = perfilService.getByUser(id);
			model.put("perfil", p);
			return new ModelAndView("perfilUsuario", model);
		} else {
			return new ModelAndView("perfilNaoExiste");
		}
	}

	@RequestMapping(value = "cropAndUpload", method = RequestMethod.POST)
	public @ResponseBody
	String cropImage(@RequestParam("x1") int x1, @RequestParam("y1") int y1,
			@RequestParam("w") int w, @RequestParam("h") int h) {

		return imageHandler.cropResizedImage(
				uploadControllerBean.getFileData(), getUsuario(), x1, y1, w, h);
	}

	// Possivel utilizacao para o album de fotos! 2_@@_@_@_@_
	@RequestMapping(value = "perfil/uploadImagens", method = RequestMethod.POST)
	public @ResponseBody
	LinkedList<FileData> uploadFotos(MultipartHttpServletRequest request,
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
	public String editarSobre(@ModelAttribute("perfil") PerfilJSON perfilJSON, BindingResult result) {
		
		usuarioService.update(getUsuario().getIdUser(), perfilJSON.getNomeUsuario(), new Date(perfilJSON.getData()));
		
		return "redirect:/home/perfil";
	}
		

	@RequestMapping(value = "perfil/salvar", method = RequestMethod.POST)
	public String salvarPerfil(
			@ModelAttribute("perfilControllerBean") PerfilControllerBean bean,
			BindingResult bindingResult) {
		PerfilTO perfilTO = bean.getPerfilTO();
		Perfil perfil = new Perfil();
		BeanUtils.copyProperties(perfilTO, perfil);
		Perfil p = perfilService.getByUser(getUsuario().getIdUser());
		
		perfil.setIdPerfil(p.getIdPerfil());
		perfil.setIdUser(p.getIdUser());
		perfilService.update(perfil);
		
		return "redirect:/home/perfil";

	}

	public PerfilTO getPerfilTO() {

		Perfil p = perfilService.getByUser(getUsuario().getIdUser());
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
