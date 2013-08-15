package br.com.webhomebeta.controller;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;

@Controller
public class AdministradorController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("admin");
	}

	@RequestMapping(value = "validarMoradores")
	public ModelAndView validarMoradores() {

		return new ModelAndView("validarMoradores", "listaUsuarios",
				usuarioService.getUsuarioNaoAtivo());
	}

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
