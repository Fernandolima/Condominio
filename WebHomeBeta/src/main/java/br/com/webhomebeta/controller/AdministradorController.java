package br.com.webhomebeta.controller;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		//Lista com permissao para copia e escrita
		List<Usuario> usuariosNaoAceitos = new CopyOnWriteArrayList<Usuario>();
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()){
			Usuario usuario = it.next();
			//se usuario tiver Status False
			if(!usuario.isStatus()){
				usuariosNaoAceitos.add(usuario);
			}
		}
		return new ModelAndView("validarMoradores","listaUsuarios",usuariosNaoAceitos);
	}
	
	@RequestMapping(value = "editarCadastro", method = RequestMethod.POST)
	public ModelAndView editarUsuario(@RequestParam("login") String loginUsuario){
		ModelAndView mv = new ModelAndView("editarCadastro");
		List<Usuario> usuarios = usuarioService.getUsuario();
		for(Usuario usuario : usuarios){ 
			if(usuario.getLogin().equals(loginUsuario)){
				mv.addObject("usuario",usuario);
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "excluirCadastro", method = RequestMethod.POST)
	public ModelAndView excluirUsuario(@PathVariable String loginUsuario){
		ModelAndView excluirmv = new ModelAndView("excluirCadastro");
		List<Usuario> usuarios = usuarioService.getUsuario();
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(loginUsuario)){
				excluirmv.addObject("usuario",usuario);
			}
		}
			
		return excluirmv;
	}
	
	@RequestMapping(value = "excluirCadastro", method = RequestMethod.POST)
	public ModelAndView listUsuario(@PathVariable String loginUsuario){
		ModelAndView listmv = new ModelAndView("excluirCadastro");
		List<Usuario> usuarios = usuarioService.getUsuario();
			
			return listmv;
	}
	
	
}
