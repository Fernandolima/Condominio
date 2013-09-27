package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.webhomebeta.service.GostouService;

@Controller
public class GostouController {
	
	@Autowired
	private GostouService gostouService;
	
	@RequestMapping(value = "gostou", method = RequestMethod.POST)
	public String gostou(){
		return null;
	}
	
}
