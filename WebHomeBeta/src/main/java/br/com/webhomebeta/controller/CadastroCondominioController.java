package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.DescricaoCondominio;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.CadastroCondominioService;
import br.com.webhomebeta.validacao.ValidatorDescricaoCondominio;

@Controller
@SessionAttributes("usuarioNaSessao")
public class CadastroCondominioController {
	@Autowired
	private CadastroCondominioService cadastroCondominioService;

	private DescricaoCondominio descricaoCondominio;

	private ValidatorDescricaoCondominio validatorDescricaoCondominio;

	// mapeia a URL principal (cadastro) e retorna um novo
	// UsuarioControllerBean()
	@RequestMapping(value = "cadastrarBlocos", method = RequestMethod.GET)
	public ModelAndView CadastraBlocos() {
		// Retorna a pagina cadastrarBlocos.jsp com um bloco criado
		return new ModelAndView("cadastrarBlocos", "bloco",
				new CadastroCondominioControllerBean());
	}

	// Pega o Objeto blco e sava na procedure DESCRICAO_CONDOMINIO_I no banco.
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "addBloco", method = RequestMethod.POST)
	// valor da action
	public ModelAndView CadastroBlocos(
			@ModelAttribute("bloco") final CadastroCondominioControllerBean bloco, // se
																					// passo
																					// o
																					// bean
			BindingResult result, HttpServletRequest request) {

		if (bloco.hasErrors()) {

			DescricaoCondominio descricao = new DescricaoCondominio();
			BeanUtils.copyProperties(bloco.getDescricaoCondominioTO(),
					descricao);
			// Salva no banco

			ArrayList<DescricaoCondominio> LisDescricao = new ArrayList<DescricaoCondominio>();
			for (DescricaoCondominio DescricaoList : LisDescricao);
			

			cadastroCondominioService.save(descricao);

			return new ModelAndView("cadastrarBlocos", "bloco", bloco);
		}

		return new ModelAndView("cadastrarBlocos", "bloco", bloco);

	}

	public void ValidaCadastroBlocos(CadastroCondominioControllerBean bean) {

		if (!validatorDescricaoCondominio.isValidAp(bean
				.getDescricaoCondominioTO().getAp())) {
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
		if (!validatorDescricaoCondominio.isValidNomeCondominio(bean
				.getDescricaoCondominioTO().getNome_condominio())) {
			bean.isNome_condiminio(false);
		} else {
			bean.isNome_condiminio(true);
		}
	}
}
