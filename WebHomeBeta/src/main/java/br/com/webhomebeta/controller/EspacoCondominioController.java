package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.EspacoCondominioTo;

@Controller
public class EspacoCondominioController {

	@Autowired
	private EspacoCondominioTo espacoCondominioTo;
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "espaco", method = RequestMethod.GET)
	private ModelAndView ExibirEspaco(ModelMap map) {
		EspacoCondominioTo acessaLista = new EspacoCondominioTo();
		acessaLista.getEspaco();
		map.put("ListaEspaco", acessaLista);
		return new ModelAndView("espaco", map);

	}

}
