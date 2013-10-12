package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.webhomebeta.bean.DadosUsuarioBean;
import br.com.webhomebeta.entity.Gostou;
import br.com.webhomebeta.entity.NaoGostou;
import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.GostouService;
import br.com.webhomebeta.service.NaoGostouService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class GostouController { 

	@Autowired
	private GostouService gostouService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private NaoGostouService naoGostouService;
	
	
	@RequestMapping(value = "removeNaoGostou", method = RequestMethod.POST)
	public String removeNaoGostou(@RequestParam("id") int id) {
		NaoGostou naoGostou = naoGostouService.get(id);
		if (getUsuario().getIdUser() == naoGostou.getIdUsuario()) {
			naoGostouService.delete(naoGostou);
			return "true";
		} else
			return "false";
	}
	
	@RequestMapping(value = "naoGostou", method = RequestMethod.POST)
	public @ResponseBody
	String naoGostou(@RequestParam("id") int id) {

		NaoGostou gostou = new NaoGostou(new Publicacao(id), getUsuario().getIdUser());
		if (naoGostouService.salvar(gostou).getId() == 0)
			return "false";
		else
			return "true";

	}

	
	@RequestMapping(value = "gostou", method = RequestMethod.POST)
	public @ResponseBody
	String gostou(@RequestParam("id") int id) {

		Gostou gostou = new Gostou(new Publicacao(id), getUsuario().getIdUser());
		if (gostouService.salvar(gostou).getId() == 0)
			return "false";
		else
			return "true";

	}

	@RequestMapping(value = "removeGostou", method = RequestMethod.POST)
	public String removeGostou(@RequestParam("id") int id) {
		Gostou gostou = gostouService.get(id);
		if (getUsuario().getIdUser() == gostou.getIdUsuario()) {
			gostouService.delete(gostou);
			return "true";
		} else
			return "false";
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
