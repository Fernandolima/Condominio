package br.com.webhomebeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
@SessionAttributes("usuarioNaSessao")
public class AdministradorController {

	@Autowired
	private UsuarioService usuarioService;

	private Usuario usuarioNaSessao;

	//Passa um usuario para a sessao do mesmo
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView show() {
		
		usuarioNaSessao = new Usuario();
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				usuarioNaSessao = usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername());

			}
		}
		return new ModelAndView("admin", "usuarioNaSessao", usuarioNaSessao);
	}

	@RequestMapping(value = "admin/validarMoradores")
	public ModelAndView validarMoradores() {

		return new ModelAndView("admin/validarMoradores", "listaUsuarios",
				usuarioService.getUsuarioNaoAtivo());
	}
	//Recebe como parametro o login do usuario e devolve o usuario com todas as informacoes
	@RequestMapping(value = "admin/editarCadastro")
	public ModelAndView editarUsuario(@RequestParam("login") String loginUsuario) {

		return new ModelAndView("admin/editarCadastro", "usuario",
				usuarioService.getUsuarioByLogin(loginUsuario));
	}


}
