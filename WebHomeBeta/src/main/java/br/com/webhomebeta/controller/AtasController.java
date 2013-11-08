package br.com.webhomebeta.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.BeanUtil;

import br.com.webhomebeta.bean.UploadArquivosAtasControllerBean;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.AtasService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.AtasTo;
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
	@RequestMapping(value = "admin/atas", method = RequestMethod.GET)
	public ModelAndView Atas(ModelMap model) {
		List<AtasEntity> atas = atasService.getListAtas();
		uploadArquivobeanUsuarios.setUsuario(getUsuario());
		model.put("listaAtas", atas);
		model.put("usuario", getUsuario());
		model.put("bean", uploadArquivobeanUsuarios);
		return new ModelAndView("atas", model);

	}
	@RequestMapping(value = "home/atas", method = RequestMethod.GET)
	public ModelAndView showAtasUser(ModelMap model){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<AtasEntity> atas = atasService.getListAtas();
		List<AtasTo> atasTo = new ArrayList<>();
		model.put("usuario", getUsuario());

		for (AtasEntity ata : atas) {
			AtasTo ataTo = new AtasTo();
			ataTo.setArquivo(ata.getArquivo());
			ataTo.setAtas(ata.getAtas());
			ataTo.setAtasAtivas(ata.isAtasAtivas());
			ataTo.setCriacaoAta(df.format(ata.getDataCriacao()));
			ataTo.setDataFormat(ata.getDataFormat());
			ataTo.setNome(ata.getNome());
			ataTo.setIdAtas(ata.getIdAtas());
			ataTo.setTitulo(ata.getTitulo());
			ataTo.setAlterada(ata.getAlterada());
			atasTo.add(ataTo);
		}
		
		model.put("atas", atasTo);
		return new ModelAndView("atasUsuario", model);
	}
	
	@RequestMapping(value = "home/atas/id={id}", method = RequestMethod.GET)
	public ModelAndView showAtaUser(@PathVariable("id") int id, ModelMap model) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		AtasEntity atasEntity = atasService.getidAtas(id);
		AtasTo ataTo = new AtasTo();
		ataTo.setArquivo(atasEntity.getArquivo());
		ataTo.setAtas(atasEntity.getAtas());
		ataTo.setAtasAtivas(atasEntity.isAtasAtivas());
		ataTo.setCriacaoAta(df.format(atasEntity.getDataCriacao()));
		ataTo.setDataFormat(atasEntity.getDataFormat());
		ataTo.setNome(atasEntity.getNome());
		ataTo.setIdAtas(atasEntity.getIdAtas());
		ataTo.setTitulo(atasEntity.getTitulo());
		ataTo.setAlterada(atasEntity.getAlterada());
		uploadArquivobeanUsuarios.setAtasTo(ataTo);
		model.addAttribute("visualizar", uploadArquivobeanUsuarios);
		return new ModelAndView("visualizarAtas", model);

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

	// Tela de Listar Atas
	@RequestMapping(value = "admin/listaAtas", method = RequestMethod.GET)
	public ModelAndView ListAtas(ModelMap model) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		List<AtasEntity> atas = atasService.getListAtas();
		List<AtasTo> atasTo = new ArrayList<>();

		for (AtasEntity ata : atas) {
			AtasTo ataTo = new AtasTo();
			ataTo.setArquivo(ata.getArquivo());
			ataTo.setAtas(ata.getAtas());
			ataTo.setAtasAtivas(ata.isAtasAtivas());
			ataTo.setCriacaoAta(df.format(ata.getDataCriacao()));
			ataTo.setDataFormat(ata.getDataFormat());
			ataTo.setNome(ata.getNome());
			ataTo.setIdAtas(ata.getIdAtas());
			ataTo.setTitulo(ata.getTitulo());
			ataTo.setAlterada(ata.getAlterada());
			atasTo.add(ataTo);
		}
		model.put("usuario", getUsuario());
		model.put("listaAtas", atasTo);
		return new ModelAndView("listaAtas", model);

	}

	@RequestMapping(value = "listaAtasAtivas", method = RequestMethod.GET)
	public ModelAndView listaAtas(ModelMap modelMap) {
		modelMap.put("listaAtas", atasService.getList(true));

		return new ModelAndView("listaAtasAtivas", modelMap);

	}

	@RequestMapping(value = "admin/atas/addArquivos", method = RequestMethod.POST)
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
			uploadArquivobeanUsuarios.setFileData(null);
			uploadArquivobeanUsuarios.setAtasTo(null);
		} else {
			uploadArquivobeanUsuarios = bean;
		}
		// cria um objeto de AtasEntity, compara com o dados to TO e salva no
		// banco.

		return "redirect:/admin/atas";
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

	@RequestMapping(value = "admin/atas/id={id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id, ModelMap model) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		AtasEntity atasEntity = atasService.getidAtas(id);
		AtasTo ataTo = new AtasTo();
		ataTo.setArquivo(atasEntity.getArquivo().substring(
				atasEntity.getArquivo().lastIndexOf("/")+1));
		ataTo.setAtas(atasEntity.getAtas());
		ataTo.setAtasAtivas(atasEntity.isAtasAtivas());
		ataTo.setCriacaoAta(df.format(atasEntity.getDataCriacao()));
		ataTo.setDataFormat(atasEntity.getDataFormat());
		ataTo.setNome(atasEntity.getNome());
		ataTo.setIdAtas(atasEntity.getIdAtas());
		ataTo.setTitulo(atasEntity.getTitulo());
		ataTo.setAlterada(atasEntity.getAlterada());
		uploadArquivobeanUsuarios.setAtasTo(ataTo);
		model.addAttribute("editar", uploadArquivobeanUsuarios);
		return new ModelAndView("editarAtas", model);

	}

	@RequestMapping(value = "admin/updateAtas", method = RequestMethod.POST)
	public String updateAtas(
			@ModelAttribute("editar") UploadArquivosAtasControllerBean bean,
			BindingResult result) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		atasService
				.updadeAtas(bean.getAtasTo().getIdAtas(), bean.getAtasTo()
						.getAtas(), bean.getAtasTo().getTitulo(), df
						.format(new Date()));
		
		if(!bean.getFileData().isEmpty()){
			alterarArquivo(bean.getFileData(),getUsuario(), bean);
		}
		
		return "redirect:/admin/listaAtas";

	}

	@RequestMapping(value = "atas/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("atas") AtasEntity atasEntity,
			BindingResult result) {
		atasService.delete(atasEntity);

		return "redirect:/inserirAtas/delete";
	}

	public void alterarArquivo(MultipartFile file, Usuario usuario, UploadArquivosAtasControllerBean bean) {
		File fileToDisk = null;
		File caminho = null;

		String caminhoPasta = this.context.getRealPath("")
				+ "/uploadedArquivos/" + usuario.getIdUser();

		String result = this.context.getRealPath("") + "/uploadedArquivos/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename();
		
		atasService.updateAtas(bean.getAtasTo().getIdAtas(), "/WebHomeBeta/uploadedArquivos/"
				+ usuario.getIdUser() + "/" + file.getOriginalFilename());
		try {

			if (file.getOriginalFilename().endsWith("pdf")) {
				caminho = new File(caminhoPasta);

				fileToDisk = new File(result);

				if (!caminho.isDirectory()) {
					caminho.mkdirs();
				}

				file.transferTo(fileToDisk);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
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
			atasEntity.setDataCriacao(new Date());
			atasEntity.setTitulo(bean.getAtasTo().getTitulo());
			atasEntity.setDataFormat(bean.getData());
			atasEntity.setAlterada("Não alterada");
			atasEntity.setUsuarioAtas(uploadArquivobeanUsuarios.getUsuario());

			bean.getAtasTo().setArquivo(null);
			bean.getAtasTo().setAtas(null);
			bean.getAtasTo().setDataFormat(null);
			bean.getAtasTo().setDataCriacao(null);
			bean.getAtasTo().setTitulo(null);
			bean.getAtasTo().setUsuarioAtas(null);
			atasService.save(atasEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
