package br.com.webhomebeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;

@Controller
@RequestMapping("/esqueciMinhaSenha")
public class EsqueciMinhaSenhaController {
	//mapeia a URL
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView esqueciMinhaSenha(){
		
		//Retorna a pagina esqueciMinhaSenha.jsp com um usuario criado
		return new ModelAndView("esqueciMinhaSenha", "usuario", new Usuario());
	}
}
