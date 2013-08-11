package br.com.webhomebeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;

@Controller
public class AdministradorController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView show(){
		return new ModelAndView("admin");
	}
	@RequestMapping(value = "validarMoradores", method = RequestMethod.GET)
	public ModelAndView validarMoradores(){
		List<Usuario> usuarios = usuarioService.getUsuario();
		for(Usuario usuario : usuarios){
			if(usuario.isStatus()){
				usuarios.remove(usuario);
			}
		}
		return new ModelAndView("validarMoradores","listaUsuarios",usuarios);
	}
	@RequestMapping(value = "editarCadastro", method = RequestMethod.POST)
	public ModelAndView editarUsuario(@PathVariable String loginUsuario){
		ModelAndView mv = new ModelAndView("editarCadastro");
		List<Usuario> usuarios = usuarioService.getUsuario();
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(loginUsuario)){
				mv.addObject("usuario",usuario);
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "inserirCadastro", method = RequestMethod.POST)
	public ModelAndView inserirUsuario(@PathVariable String loginUsuario){
		ModelAndView inserirmv = new ModelAndView("editarCadastro");
		List<Usuario> usuarios = usuarioService.getUsuario();
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(loginUsuario)){
				inserirmv.addObject("usuario",usuario);
			}
		}
			
		return inserirmv;
	}
	
	
}
