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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Funcionario;
import br.com.webhomebeta.service.FuncionarioService;
import br.com.webhomebeta.validacao.ValidadorFuncionario;

@Controller
@SessionAttributes("usuarioNaSessao")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	private Funcionario funcionario;
	private ValidadorFuncionario funcionarioValidador = new ValidadorFuncionario();

	// mapeia a URL principal (funcionario) e retorna um novo
	// FuncionarioControllerBean()
	@RequestMapping(value = "funcionario", method = RequestMethod.GET)
	public ModelAndView Funcionario(ModelMap map) {
		java.util.List<Funcionario> funcionario = new FuncionarioService()
				.getFuncionario();
		map.put("listaFuncionario", funcionario);
		map.put("addFuncionario", new FuncionarioControllerBean());
		// Retorna a pagina funcionario.jsp com os funcioarios criado
		return new ModelAndView("funcionario", map);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "addFuncionario", method = RequestMethod.POST)
	// valor da action
	public ModelAndView Funcionario(
			@ModelAttribute("funcionario") final FuncionarioControllerBean bean,
			// bean
			BindingResult result, HttpServletRequest request) {
		ValidadorFuncionario(bean);
		if (bean.hasErrors()) {

			// cria um objeto de AtasEntity, compara com o dados to TO e salva
			// no
			// banco.
			Funcionario descricao = new Funcionario();
			BeanUtils.copyProperties(bean.getFuncionarioTo(), descricao);
			// Salva no banco

			funcionarioService.save(descricao);

			return new ModelAndView("inserirFuncionario");
		}

		return new ModelAndView("inserirAtas", "funcionario", bean);
	}

	public void ValidadorFuncionario(
			FuncionarioControllerBean funcionarioControllerBean) {

		if (!funcionarioValidador
				.isValidNomeFuncionario(funcionarioControllerBean
						.getFuncionarioTo().getName()))
			;

	}
}
