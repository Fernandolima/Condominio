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

@Controller
@SessionAttributes("usuarioNaSessao")
public class AdministradorController {

	@Autowired
	private UsuarioService usuarioService;

	private Usuario usuarioNaSessao;

	public AdministradorController() {

		usuarioNaSessao = new Usuario();
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				usuarioNaSessao = usuarioService
						.getUsuarioByLogin(((User) authentication
								.getPrincipal()).getUsername());

			}
		}
	}
	//Passa um usuario para a sessao do mesmo
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("admin", "usuarioNaSessao", usuarioNaSessao);
	}

	@RequestMapping(value = "validarMoradores")
	public ModelAndView validarMoradores() {

		return new ModelAndView("validarMoradores", "listaUsuarios",
				usuarioService.getUsuarioNaoAtivo());
	}
	//Recebe como parametro o login do usuario e devolve o usuario com todas as informacoes
	@RequestMapping(value = "editarCadastro")
	public ModelAndView editarUsuario(@RequestParam("login") String loginUsuario) {

		return new ModelAndView("editarCadastro", "usuario",
				usuarioService.getUsuarioByLogin(loginUsuario));
	}

	@RequestMapping(value = "excluirCadastro", method = RequestMethod.POST)
	public ModelAndView excluirUsuario(@PathVariable String loginUsuario) {
		ModelAndView excluirmv = new ModelAndView("excluirCadastro");
		List<Usuario> usuarios = usuarioService.getUsuario();
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(loginUsuario)) {
				excluirmv.addObject("usuario", usuario);
			}
		}

		return excluirmv;
	}

	@RequestMapping(value = "excluirCadastro", method = RequestMethod.POST)
	public ModelAndView listUsuario(@PathVariable String loginUsuario) {
		ModelAndView listmv = new ModelAndView("excluirCadastro");
		List<Usuario> usuarios = usuarioService.getUsuario();

		return listmv;
	}

}
