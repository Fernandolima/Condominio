package br.com.webhomebeta.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.EspacoCondominioBean;
import br.com.webhomebeta.entity.EspacoCondominio;
import br.com.webhomebeta.service.EspacoCondominioServe;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.EspacoCondominioTo;
import br.com.webhomebeta.validacao.ValidadorEspaco;

@Controller
public class EspacoCondominioController {

	private EspacoCondominioTo espacoCondominioTo;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EspacoCondominioServe condominioServe;
	
	private EspacoCondominio condominio;
	
	private ValidadorEspaco ValidadorEspaco = new ValidadorEspaco();

	@RequestMapping(value = "espaco", method = RequestMethod.GET)
	private ModelAndView ExibirEspaco(ModelMap map) {
		EspacoCondominioTo acessaLista = new EspacoCondominioTo();
		acessaLista.getEspaco();
		map.put("ListaEspaco", acessaLista);
		return new ModelAndView("espaco", map);

	}

	@RequestMapping(value = "inserirEspaco", method = RequestMethod.POST)
	// valor da action
	public ModelAndView InserirEspaco(
			@ModelAttribute("espaco") final EspacoCondominioBean Bean,
			BindingResult result, HttpServletRequest request) {
		ValidadorEspaco(Bean);
		if (Bean.hasErrors()) {

			// cria um objeto de EspacoCondominio, compara com o dados to TO e
			// salva
			// no
			// banco.
			EspacoCondominio descricao = new EspacoCondominio();
			BeanUtils.copyProperties(Bean.getEspacoCondominioTo(), descricao);
			// Salva no banco

			condominioServe.save(descricao);

			return new ModelAndView("inserirEspaco");
		}

		return new ModelAndView("inserirEspaco", "espaco", Bean);
	}

	public void ValidadorEspaco(EspacoCondominioBean espacoCondominioBean) {

		if (!ValidadorEspaco.isValidEspaco(espacoCondominioBean
				.getEspacoCondominioTo().getEspaco()))
			;
		;
		{
			espacoCondominioBean.isNameEspaco(false);

		}
		espacoCondominioBean.isNameEspaco(true);

		if (!ValidadorEspaco.validaData(espacoCondominioBean
				.getEspacoCondominioTo().getData())) {
			espacoCondominioBean.isValidDate(false);

		}
		espacoCondominioBean.isValidDate(true);

	}

}
