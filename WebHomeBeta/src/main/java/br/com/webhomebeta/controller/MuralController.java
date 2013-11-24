package br.com.webhomebeta.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.DadosUsuarioBean;
import br.com.webhomebeta.bean.MuralBean;
import br.com.webhomebeta.entity.Mural;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.MuralService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.MuralTO;

@Controller
public class MuralController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MuralService muralService;
	@Autowired
	private DadosUsuarioBean bean;

	@RequestMapping(value = "admin/mural", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		model.put("mural", new MuralBean());
		model.put("usuario", getUsuario());
		model.put("list", muralService.getList());
		return new ModelAndView("mural", model);

	}

	@RequestMapping(value = "admin/mural/save", method = RequestMethod.POST)
	public @ResponseBody String save(@ModelAttribute("bean") MuralBean bean,
			BindingResult result) {
		
		if(bean.getMuralTO().getTitulo().equals("")){
			return "erro";
		}
		if(bean.getMuralTO().getNoticia().equals("")){
			return "erro";
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Mural mural = new Mural();
		bean.getMuralTO().setData((df.format(new Date())));
		BeanUtils.copyProperties(bean.getMuralTO(), mural);
		muralService.save(mural);
		
		return "true";

	}

	@RequestMapping(value = "mural/delete={idMural}", method = RequestMethod.GET)
	public void delete(@PathVariable("idMural") int idMural) {
		Mural mural = muralService.get(idMural);
		muralService.delete(mural);
	}

	@RequestMapping(value = "mural/update", method = RequestMethod.POST)
	public void updatemural(@ModelAttribute("editar") MuralBean bean,
			BindingResult result) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Mural mural = new Mural();
		mural.setData(bean.getMuralTO().getData());
		mural.setDataAlterada(df.format(new Date()));
		mural.setIdMural(bean.getMuralTO().getIdMural());
		mural.setNoticia(bean.getMuralTO().getNoticia());

		muralService.update(mural);

	}
	
	@RequestMapping(value = "home/mural/id={idMural}", method = RequestMethod.GET)
	public ModelAndView muralID(@PathVariable("idMural") int idMural, ModelMap model) {
		Mural mural = muralService.get(idMural);
		model.put("usuario", getUsuario());
		model.put("mural", mural);
		return new ModelAndView("visualizarMural", model);
	}

	
	
	@RequestMapping(value = "home/mural", method = RequestMethod.GET)
	public ModelAndView muralUsuario(ModelMap model) {
		model.put("usuario", getUsuario());
		model.put("listaMural", muralService.getList());
		return new ModelAndView("muralUsuario", model);

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
