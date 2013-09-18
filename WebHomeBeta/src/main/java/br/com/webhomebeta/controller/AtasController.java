package br.com.webhomebeta.controller;

import java.io.File;
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

import br.com.webhomebeta.bean.AtasControllerBean;
import br.com.webhomebeta.bean.UploadArquivosControllerBean;
import br.com.webhomebeta.bean.UploadControllerBean;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.AtasService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.validacao.ValidadorAtas;

@Controller
public class AtasController {
	@Autowired
	private ServletContext context;
	@Autowired
	private AtasService atasService;
	private AtasEntity atasEntity;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UploadControllerBean beanUsuarios;
	private ValidadorAtas validadorAtas = new ValidadorAtas();

	// mapeia a URL principal (Atas) e retorna um novo objeto atas
	@RequestMapping(value = "atas", method = RequestMethod.GET)
	public ModelAndView Atas(ModelMap model) {
		List<AtasEntity> atas = atasService.getList();

		// Retorna a pagina inserirAtas.jsp com uma ata criado

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
		model.put("listaAtas", atas);
		model.put("Arquivo", beanUsuarios);
		model.put("atas", new AtasControllerBean());
		return new ModelAndView("uploadArquivo", model);

	}

	@RequestMapping(value = "addArquivos", method = RequestMethod.POST)
	// valor da action
	public ModelAndView AtasArquivos(
			@ModelAttribute("atas") final AtasControllerBean bean,
			BindingResult result, HttpServletRequest request) throws Exception {
		SecurityContext context = SecurityContextHolder.getContext();
		salvar(bean.getFileData(), atasEntity, beanUsuarios.getUsuario());
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
		
		// cria um objeto de AtasEntity, compara com o dados to TO e salva  no banco.
//		AtasEntity descricao = new AtasEntity();
//		//BeanUtils.copyProperties(bean.getAtasTo(), descricao);
//		// Salva no banco
//
//		atasService.save(descricao);

		return new ModelAndView("uploadArquivo", "atas", bean);
	}

	public void ValidadorAtas(AtasControllerBean atasBean,
			UploadControllerBean bean){

		if (!validadorAtas.isValidAtas(atasBean.getAtasTo().getAtas()))
			;
		{
			atasBean.isAtas(false);

		}
		atasBean.isAtas(true);
		if (!validadorAtas.validaData(atasBean.getData())) {
			atasBean.isValidDate(false);
		} else
			atasBean.isValidDate(true);
	
	}

	@RequestMapping(value = "atas/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("idAta") int id,
			BindingResult result, HttpServletRequest request) {
		AtasEntity descricaoAtas = atasService.editar(id);
		return new ModelAndView("inserirAtas/editar", "atas", atasEntity);

	}

	@RequestMapping(value = "atas/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("atas") AtasEntity atasEntity,
			BindingResult result) {

		atasService.update(atasEntity);

		return "redirect:/inserirAtas/editar";

	}

	@RequestMapping(value = "atas/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("atas") AtasEntity atasEntity,
			BindingResult result) {
		atasService.delete(atasEntity);

		return "redirect:/inserirAtas/delete";
	}

	private void salvar(MultipartFile file, AtasEntity atasEntity,
			Usuario usuario) throws Exception {
		File fileToDisk = null;
		File caminho = null;

		String caminhoPasta = this.context.getRealPath("")
				+ "/uploadedArquivos/" + usuario.getIdUser();

		String result = this.context.getRealPath("") + "/uploadedArquivos/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();
		try {

			if (file.getOriginalFilename().endsWith("pdf")) {
				caminho = new File(caminhoPasta);

				fileToDisk = new File(result);

				if (!caminho.isDirectory()) {
					caminho.mkdir();
				}

				file.transferTo(fileToDisk);

			}

			usuario.setNome(result);
			atasEntity.setArquivo("/WebHomeBeta/uploadedArquivos/"
					+ usuario.getIdUser() + "/" + file.getOriginalFilename());
			atasService.update(atasEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
