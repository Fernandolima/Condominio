package br.com.webhomebeta.controller;

import java.io.ObjectInputStream.GetField;
import java.util.Map;

import javassist.expr.NewArray;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EmailServico;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.UsuarioTO;

@Controller
@RequestMapping("/cadastro")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmailServico emailServico;

	// mapeia a URL
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView cadastro() {
		// Retorna a pagina cadastro.jsp com um usuario criado
		return new ModelAndView("cadastro", "usuario", new Usuario());
	}

	// Pega o Objeto usuario e sava na tabela USER no banco.
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String print(@ModelAttribute("usuario") Usuario usuario,
			BindingResult result) {
		usuario.setStatus(false);
		usuario.setPermissao("ROLE_MORADOR");
		String email = usuario.getEmail();
		usuario.setLogin(email);
		ValidacoesController validacoesController = new ValidacoesController();
		validacoesController.isValidCPF(usuario.getCpf());
		usuarioService.save(usuario);
		emailServico.enviarEmail();
		return "index";
	
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
}
