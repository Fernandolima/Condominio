package br.com.webhomebeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EmailServico;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.UsuarioTO;

@Controller
public class ValidarCadastroController {
	
	//mapeia a URL
	@RequestMapping(value = "validarCadastro", method = RequestMethod.GET)
	public ModelAndView esqueciMinhaSenha(){
		
		//Retorna a pagina esqueciMinhaSenha.jsp com um usuario criado
		return new ModelAndView("validarCadastro");
	}	
}
