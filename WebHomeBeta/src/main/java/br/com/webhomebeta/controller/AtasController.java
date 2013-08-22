package br.com.webhomebeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.dao.AtasDao;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.DescricaoCondominio;
import br.com.webhomebeta.service.AtasService;

@Controller
@SessionAttributes("AtasService")
public class AtasController {
	@Autowired
	private AtasService atasService;

	private AtasEntity atasEntity;

	// mapeia a URL principal (Atas) e retorna um novo objeto atas
	@RequestMapping(value = "inserirAtas", method = RequestMethod.GET)
	public ModelAndView CadastraBlocos(ModelMap model) {
		List<AtasEntity> atas = atasService.getList();
		model.put("listaBlocos", atas);
		model.put("atas", new CadastroCondominioControllerBean());
		// Retorna a pagina cadastrarBlocos.jsp com um bloco criado
		return new ModelAndView("inserirAtas", model);
	}

}
