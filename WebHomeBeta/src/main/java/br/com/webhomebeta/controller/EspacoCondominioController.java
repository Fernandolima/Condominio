package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.EspacoCondominioBean;
import br.com.webhomebeta.entity.EspacoCondominio;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EspacoCondominioServe;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
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
	public void InserirEspaco(
			@ModelAttribute("bean") EspacoCondominioBean bean,
			BindingResult result) {
		// vare a lista e adiciona os dados do espaço.
		for (String novoEespaco : bean.getListEspaco()) {
			EspacoCondominio espacoCondominio = new EspacoCondominio(bean
					.getEspacoCondominioTo().getNovoEspaco(), bean
					.getEspacoCondominioTo().getQuatEspaco(), false, bean
					.getEspacoCondominioTo().getNome());

			condominioServe.save(espacoCondominio);

		}
	}

	@RequestMapping(value = "deleteEspaco", method = RequestMethod.POST)
	public void deleteEspaco(
			@ModelAttribute("bean") EspacoCondominio espacoCondominio) {
		condominioServe.delete(espacoCondominio);
	}

	public Usuario getUsuario() {

		Usuario usuario = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				usuario = usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername());

			}
		}

		return usuario;
	}

}
