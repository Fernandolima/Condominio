package br.com.webhomebeta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.CadastroCondominioControllerBean;
import br.com.webhomebeta.entity.DescricaoCondominio;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.Json;
import br.com.webhomebeta.json.JsonBlocos;
import br.com.webhomebeta.service.CadastroCondominioService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.validacao.ValidatorDescricaoCondominio;

@Controller
public class CadastroCondominioController {
	@Autowired
	private CadastroCondominioService cadastroCondominioService;

	private ValidatorDescricaoCondominio validatorDescricaoCondominio = new ValidatorDescricaoCondominio();

	@Autowired
	private UsuarioService usuarioService;

	// mapeia a URL principal (cadastro) e retorna um novo
	// UsuarioControllerBean() e uma lista de blocos

	@RequestMapping(value = "admin/cadastrarBlocos", method = RequestMethod.GET)
	public ModelAndView CadastraBlocos(ModelMap model) {
		List<DescricaoCondominio> blocos = cadastroCondominioService
				.getDescricao();
		model.put("listaBlocos", blocos);
		model.put("bloco", new CadastroCondominioControllerBean());
		model.put("usuario", getUsuario());
		// Retorna a pagina cadastrarBlocos.jsp com um bloco criado
		return new ModelAndView("cadastrarBlocos", model);
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

	// Pega o Objeto bloco e sava na procedure DESCRICAO_CONDOMINIO_I no banco.
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "addBloco", method = RequestMethod.POST)
	// valor da action
	public ModelAndView CadastroBlocos(
			@ModelAttribute("bloco") final CadastroCondominioControllerBean bloco, // se
																					// passo
																					// o
																					// bean
			BindingResult result, HttpServletRequest request) {
		ValidaCadastroBlocos(bloco);
		if (bloco.hasErrors()) {

			DescricaoCondominio descricao = new DescricaoCondominio();
			BeanUtils.copyProperties(bloco.getDescricaoCondominioTO(),
					descricao);
			// Salva no banco

			bloco.getDescricaoCondominioTO().setBloco(null);
			bloco.getDescricaoCondominioTO().setNumeroInicia(null);
			bloco.getDescricaoCondominioTO().setQuantAp(null);
			bloco.getDescricaoCondominioTO().setQuatApAndares(null);
			
			cadastroCondominioService.save(descricao);

			return new ModelAndView("cadastrarBlocos");
		}

		return new ModelAndView("cadastrarBlocos", "bloco", bloco);
	}

	@RequestMapping(value = "cadastro/editar", method = RequestMethod.POST)
	public ModelAndView editar(@RequestParam("idcondomnio") int id,
			BindingResult result, HttpServletRequest request) {
		DescricaoCondominio descricaoCondominio = cadastroCondominioService
				.editar(id);
		return new ModelAndView("cadastrarBlocos/editar", "bloco",
				descricaoCondominio);

	}

	@RequestMapping(value = "cadastro/update", method = RequestMethod.POST)
	public String update(
			@ModelAttribute("bloco") DescricaoCondominio descricaoCondominio,
			BindingResult result) {

		cadastroCondominioService.update(descricaoCondominio);

		return "redirect:/cadastrarBlocos";

	}

	@RequestMapping(value = "cadastro/delete", method = RequestMethod.POST)
	// ResponseBody retorna um JSON.
	public @ResponseBody
	Json delete(
	// recebe o id do bloco a ser excluido
			@RequestParam int idbloco) {
		DescricaoCondominio descricaoCondominio = cadastroCondominioService.get(idbloco);
		cadastroCondominioService.delete(descricaoCondominio);
		return new Json("true");
	}

	// ResponseBody retorna um JSON.
	@RequestMapping(value = "admin/cadastro/salvarBloco", method = RequestMethod.POST)
	public @ResponseBody
	//Nome da Class do Json Criado JsonBlocos e depois o metodo.
	JsonBlocos save(
			// recebe o id do bloco a ser excluido
			@ModelAttribute("addbloco") CadastroCondominioControllerBean bloco,
			BindingResult bindingResult) {
		DescricaoCondominio descricaoCondominio = new DescricaoCondominio();
		BeanUtils.copyProperties(bloco.getDescricaoCondominioTO(),
				descricaoCondominio);
		cadastroCondominioService.save(descricaoCondominio);
		
		//Cria um objeto do JsonBlocos e depois acessa o mesmo pelo bloco.alguma coisa
		JsonBlocos jsonbloco = new JsonBlocos(bloco.getDescricaoCondominioTO()
				.getBloco(), descricaoCondominio.getIdbloco(),
				Integer.parseInt(bloco.getDescricaoCondominioTO().getQuatApAndares()), bloco
						.getDescricaoCondominioTO().getNumeroInicia(), bloco
						.getDescricaoCondominioTO().getQuantAp());

		// ----------------------------------------s

		return jsonbloco;
	}

	public void ValidaCadastroBlocos(CadastroCondominioControllerBean bean) {

		if (!validatorDescricaoCondominio.isValidAp(bean
				.getDescricaoCondominioTO().getQuantAp())) {
			bean.isAp(false);
		} else {
			bean.isAp(true);
		}

		if (!validatorDescricaoCondominio.isValidBloco(bean
				.getDescricaoCondominioTO().getBloco())) {
			bean.isBloco(false);
		} else {
			bean.isBloco(true);
		}
	}
}