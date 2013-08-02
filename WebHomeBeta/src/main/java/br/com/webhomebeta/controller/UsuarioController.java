package br.com.webhomebeta.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.exceptions.CPFException;
import br.com.webhomebeta.exceptions.EmailException;
import br.com.webhomebeta.exceptions.NomeException;
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

	// mapeia a URL principal (cadastro) e retorna um novo UsuarioControllerBean()

	@RequestMapping(value = "cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		// Retorna a pagina cadastro.jsp com um usuario criado
		return new ModelAndView("cadastro", "bean", new UsuarioControllerBean());
	}

	// Pega o Objeto usuario e sava na tabela USER no banco.
	@RequestMapping(value = "cadastro/add", method = RequestMethod.POST)
	public ModelAndView cadastro(
			@ModelAttribute("bean") final UsuarioControllerBean bean) {

		try {
			if (!validarCadastro(bean.getUsuarioTO())) {
				
			}else{
				
				Usuario usuario = new Usuario();
				BeanUtils.copyProperties(bean.getUsuarioTO(), usuario);
				usuarioService.save(usuario);
				
			}
		} catch (NomeException e) {
			bean.setValidName(false);
		} catch (CPFException e) {
			bean.setValidCpf(false);
		} catch (EmailException e) {
			bean.setValidEmail(false);
		}

		return new ModelAndView("cadastro", "bean", bean);
	}

	private boolean validarCadastro(UsuarioTO usuarioTO) throws NomeException,
			EmailException, CPFException {

		if (usuarioTO.getNome().length() < 3
				|| usuarioTO.getNome().length() > 50) {
			throw new NomeException();
		}

		if (validacoesController.isValidCPF(usuarioTO.getCpf())) {
			throw new CPFException();
		}
		if (validacoesController.isValidEmail(usuarioTO.getEmail())) {
			throw new EmailException();
		}

		return true;
	}

	// usuario.setStatus(false);
	// usuario.setPermissao("ROLE_MORADOR");
	// String email = usuario.getEmail();
	// usuario.setLogin(email);
	// ValidacoesController validacoesController = new ValidacoesController();
	// validacoesController.isValidCPF(usuario.getCpf());
	// usuarioService.save(usuario);
	// emailServico.enviarEmail();
	// return "index";

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String showUserForm(Model model) {
	// model.addAttribute("usuario",new Usuario());
	// return "index";
	// }
	//
	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	// public void save(Usuario usuario){
	// usuarioService.save(usuario);
	//
	// }

}
