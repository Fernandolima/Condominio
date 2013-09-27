package br.com.webhomebeta.controller;

import java.io.File;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.UploadArquivosAtasControllerBean;
import br.com.webhomebeta.bean.UploadControllerBean;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.AtasService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.validacao.ValidadorAtas;
//atas de assembleia
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
	private UploadArquivosAtasControllerBean uploadArquivobeanUsuarios;

	private ValidadorAtas validadorAtas = new ValidadorAtas();

	// mapeia a URL principal (Atas) e retorna um novo objeto atas
	@RequestMapping(value = "atas", method = RequestMethod.GET)
	public ModelAndView Atas(ModelMap model) {
		List<AtasEntity> atas = atasService.getList();
		// beanUsuarios.getFileData();
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				uploadArquivobeanUsuarios.setUsuario(usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername()));

			}
		}
		model.put("listaAtas", atas);
		model.put("bean", uploadArquivobeanUsuarios);
		return new ModelAndView("atas", model);

	}

	// Tela de Listar Atas
	@RequestMapping(value = "listaAtas", method = RequestMethod.GET)
	public ModelAndView ListAtas(ModelMap model) {
		List<AtasEntity> atas = atasService.getList();

		model.put("listaAtas", atas);
		return new ModelAndView("listaAtas", model);

	}

	
	
	@RequestMapping(value = "atas/addArquivos", method = RequestMethod.POST)
	// valor da action
	public String AtasArquivos(
			@ModelAttribute("bean") final UploadArquivosAtasControllerBean bean,
			BindingResult result, HttpServletRequest request) throws Exception {
		// Chama o metodo validar Atas
		ValidadorAtas(bean);
		// passa o bean do validar.
		if (bean.hasErrors()) {
			salvar(bean.getFileData(), atasEntity,
					uploadArquivobeanUsuarios.getUsuario(), bean);
		}
		// cria um objeto de AtasEntity, compara com o dados to TO e salva no
		// banco.
		uploadArquivobeanUsuarios = bean;

		return "redirect:/atas";
	}

	public void ValidadorAtas(UploadArquivosAtasControllerBean atasBean) {

		if (!validadorAtas.isValiTitulo(atasBean.getAtasTo().getTitulo()))
			atasBean.setTitulo(false);
		else
			atasBean.setTitulo(true);

		if (!validadorAtas.isValidAtas(atasBean.getAtasTo().getAtas()))

		{
			atasBean.setAtas(false);
		} else {
			atasBean.setAtas(true);
		}
		if (!validadorAtas.validaData(atasBean.getData()))

		{
			atasBean.setDataVal(false);

		} else {
			atasBean.setDataVal(true);

		}
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

		// atasService.update(result);

		return "redirect:/inserirAtas/editar";

	}

	@RequestMapping(value = "atas/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("atas") AtasEntity atasEntity,
			BindingResult result) {
		atasService.delete(atasEntity);

		return "redirect:/inserirAtas/delete";
	}

	private void salvar(MultipartFile file, AtasEntity atasEntity,
			Usuario usuario, UploadArquivosAtasControllerBean bean)
			throws Exception {
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
					caminho.mkdirs();
				}

				file.transferTo(fileToDisk);

			}
			atasEntity = new AtasEntity();
			atasEntity.setArquivo("/WebHomeBeta/uploadedArquivos/"
					+ usuario.getIdUser() + "/" + file.getOriginalFilename());
			atasEntity.setAtas(bean.getAtasTo().getAtas());
			atasEntity.setDataATA(bean.getAtasTo().getDataAta());
			atasEntity.setDataCriacao(new Date());
			atasEntity.setTitulo(bean.getAtasTo().getTitulo());
			atasEntity.setUsuarioAtas(uploadArquivobeanUsuarios.getUsuario());

			bean.getAtasTo().setArquivo(null);
			bean.getAtasTo().setAtas(null);
			bean.getAtasTo().setDataAta(null);
			bean.getAtasTo().setDataCriacao(null);
			bean.getAtasTo().setTitulo(null);
			bean.getAtasTo().setUsuario(null);
			atasService.save(atasEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
