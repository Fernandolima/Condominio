package br.com.webhomebeta.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EmailServico;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.UsuarioTO;

@Controller
public class EsqueciMinhaSenhaController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmailServico emailServico;

	// mapeia a URL
	@RequestMapping(value = "esqueciMinhaSenha", method = RequestMethod.GET)
	public ModelAndView esqueciMinhaSenha() {

		// Retorna a pagina esqueciMinhaSenha.jsp com um usuario criado
		return new ModelAndView("esqueciMinhaSenha", "usuario", new UsuarioTO());
	}

	@RequestMapping(value = "enviarEmail", method = RequestMethod.POST)
	public ModelAndView enviarEmail(
			@ModelAttribute("usuario") UsuarioTO usuarioTO) {
		// Cria a variavel booleana validEmail
		boolean validEmail = false;
		// Recebe a lista de usuarios do banco
		List<Usuario> usuarios = usuarioService.getUsuario();
		// Compara cada usuario da lista e verifica se o email existe
		for (Usuario user : usuarios) {
			// se existir envia email de perda de senha
			if (user.getEmail().equals(usuarioTO.getEmail())) {
				ModelAndView mv = new ModelAndView("pagina de confirmacao de email enviado");
				// adiciona ao model a variavel validEmail
				UUID uuid = UUID.randomUUID();
				String myRandom = uuid.toString();
				String senhaGerada = myRandom.substring(0, 6);
				usuarioTO.setSenha(senhaGerada);
				emailServico.emailAlteracaoSenha(usuarioTO);
				return mv;
			} else {
				validEmail = false;
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("isValidEmail",validEmail);
		return new ModelAndView("esqueciMinhaSenha", "usuario", new UsuarioTO());

	}

}
