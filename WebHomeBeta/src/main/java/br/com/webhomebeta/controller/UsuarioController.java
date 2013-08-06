package br.com.webhomebeta.controller;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.exceptions.CPFException;
import br.com.webhomebeta.exceptions.EmailException;
import br.com.webhomebeta.exceptions.NomeException;
import br.com.webhomebeta.exceptions.SenhaException;
import br.com.webhomebeta.service.EmailServico;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.UsuarioTO;
import br.com.webhomebeta.validacao.ValidacoesController;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmailServico emailServico;

	private ValidacoesController validacoesController = new ValidacoesController();

	// mapeia a URL principal (cadastro) e retorna um novo
	// UsuarioControllerBean()
	@RequestMapping(value = "cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		// Retorna a pagina cadastro.jsp com um usuario criado
		return new ModelAndView("cadastro", "bean", new UsuarioControllerBean());
	}

	// Pega o Objeto usuario e sava na tabela USER no banco.
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView cadastro(
			@ModelAttribute("bean") final UsuarioControllerBean bean,
			BindingResult result, HttpServletRequest request) {
		
		validarCadastro(bean);
		
		if (bean.hasErrors()) {
			bean.getUsuarioTO().setLogin(bean.getUsuarioTO().getEmail());
			bean.getUsuarioTO().setPermissao("ROLE_MORADOR");
			Usuario usuario = new Usuario();
			BeanUtils.copyProperties(bean.getUsuarioTO(), usuario);
			usuarioService.save(usuario);
		}

		return new ModelAndView("cadastro", "bean", bean);

	}

	private void validarCadastro(UsuarioControllerBean bean) {

		if (bean.getUsuarioTO().getSenha().length() < 6
				&& !bean.getUsuarioTO().getSenha().equals(bean.getConfSenha()))
			bean.setValidSenha(false);
		else
			bean.setValidSenha(true);

		if (bean.getUsuarioTO().getNome().length() < 3
				|| bean.getUsuarioTO().getNome().length() > 50)
			bean.setValidName(false);
		else
			bean.setValidName(true);

		if (!validacoesController.isCPF(bean.getUsuarioTO().getCpf()))
			bean.setValidCpf(false);
		else
			bean.setValidCpf(true);

		if (!validacoesController.isValidEmail(bean.getUsuarioTO().getEmail()))
			bean.setValidEmail(false);
		else
			bean.setValidEmail(true);

	}

}
