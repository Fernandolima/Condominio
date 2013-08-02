package br.com.webhomebeta.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EmailServico;
import br.com.webhomebeta.service.UsuarioService;

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
		isValidCPF(usuario.getCpf());
		usuarioService.save(usuario);
		emailServico.enviarEmail();
		return "redirect:/cadastro";
	}
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	public static boolean isValidCPF(String cpf) {
		if ((cpf == null) || (cpf.length() != 11))
			return false;

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString()
				+ digito2.toString());
		
}
	 public static boolean validarEmail(String email)
	    {
	        boolean isEmailIdValid = false;
	        if (email != null && email.length() > 0) {
	            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	            Matcher matcher = pattern.matcher(email);
	            if (matcher.matches()) {
	                isEmailIdValid = true;
	            }
	        }
	        return isEmailIdValid;
	    }
	

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
