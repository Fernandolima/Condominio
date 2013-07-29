package br.com.webhomebeta.controller;



import java.util.Map;

import javassist.expr.NewArray;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.UsuarioTO;



@Controller
@RequestMapping("/cadastro")
public class UsuarioController{
	
	@Autowired
	private UsuarioService usuarioService;
	
	//mapeia a URL
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public ModelAndView cadastro(){
		//Retorna a pagina cadastro.jsp com um usuario criado
		return new ModelAndView("cadastro", "usuario", new Usuario());
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String print(@ModelAttribute("usuario")Usuario usuario, BindingResult result){
		
		usuarioService.save(usuario);
		return "usuario";
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
