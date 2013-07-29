package br.com.webhomebeta.controller;



import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.UsuarioTO;



@Controller
@RequestMapping("/")
public class UsuarioController{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String print(ModelMap model){
		model.addAttribute("message","funciona issso bosta");
		return "hello";
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//    public String showUserForm(Model model) {
//        model.addAttribute("usuario",new Usuario());
//        return "index";
//    }
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public void save(Usuario usuario){
//		usuarioService.save(usuario);
//		
//	}
	
}
