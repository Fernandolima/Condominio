package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.webhomebeta.service.security.SecurityContextAcessor;

@Controller
public class AuthenticationController {
	@Autowired
	private SecurityContextAcessor securityContextAcessor;
	
	@Autowired
	@Qualifier("defaultTargetUrl")
	private String defaultTargetUrl;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String login(){
		if(securityContextAcessor.isConectadoAnonimamente())
			return "index";
		else
			return "redirect:" + defaultTargetUrl;
	}
	
	
}
