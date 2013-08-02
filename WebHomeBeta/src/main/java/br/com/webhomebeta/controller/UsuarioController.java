package br.com.webhomebeta.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class UsuarioController{
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmailServico emailServico;
	
	Vector<Boolean> internal = new Vector<>();
	ArrayList<Boolean> list = new ArrayList<>();
	
	//mapeia a URL
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView cadastro(ModelMap map){
		list.add(true);
		list.add(false);
		list.add(true);
		//Retorna a pagina cadastro.jsp com um usuario criado
		map.put("list", list);
		return new ModelAndView("cadastro", "usuario", new Usuario());
	}
	
	//Pega o Objeto usuario  e sava na tabela USER no banco.
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String print(@ModelAttribute("usuario")Usuario usuario, BindingResult result){
		usuario.setStatus(false);
		usuario.setPermissao("ROLE_MORADOR");
		String email = usuario.getEmail();
		usuario.setLogin(email);
		usuarioService.save(usuario);
		emailServico.enviarEmail();
		return "index";
	}
	
	 public static boolean validar(String email)
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

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//    public String showUserForm(Model model) {
//        model.addAttribute("usuario",new Usuario());
//        return "index";
//    }
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public void save(Usuario usuario){
//		usuarioService.save(usuario);
//		
//	}
	
}
