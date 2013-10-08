package br.com.webhomebeta.controller;

import java.util.Date;

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
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.UsuarioControllerBean;
import br.com.webhomebeta.entity.Perfil;
import br.com.webhomebeta.entity.Usuario;

import br.com.webhomebeta.service.EmailServico;
import br.com.webhomebeta.service.PerfilService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.validacao.Validator;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmailServico emailServico;
	@Autowired
	private PerfilService perfilService;

	private Validator validator = new Validator();

	// mapeia a URL principal (cadastro) e retorna um novo
	// UsuarioControllerBean()
	@RequestMapping(value = "cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro(ModelMap model) {
		model.put("usuario", getUsuario());
		model.put("bean", new UsuarioControllerBean());
		// Retorna a pagina cadastro.jsp com um usuario criado
		return new ModelAndView("cadastro", model);
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

	// Pega o Objeto usuario e sava na tabela USER no banco.
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView cadastro(
			@ModelAttribute("bean") final UsuarioControllerBean bean,
			BindingResult result, HttpServletRequest request) {

		validarCadastro(bean);

		if (bean.hasErrors()) {
			// Seta a role
			bean.getUsuarioTO().setLogin(bean.getUsuarioTO().getEmail());
			bean.getUsuarioTO().setPermissao("ROLE_MORADOR");
			bean.getUsuarioTO().setImagem("/WebHomeBeta/img/anonimos.jpg");
			bean.getUsuarioTO().setStatus(false);
			bean.getUsuarioTO().setCargo("Morador");
			// Insere a data
			Date data = new Date(bean.getData());
			bean.getUsuarioTO().setDt_nascimento(data);

			Usuario usuario = new Usuario();
			// Passa as propriedades do usuarioTO para a entidade usuario
			BeanUtils.copyProperties(bean.getUsuarioTO(), usuario);
			// Salva no banco
			usuarioService.save(usuario);

			bean.getUsuarioTO().setCpf(null);
			bean.getUsuarioTO().setDt_nascimento(null);
			bean.setData("");
			bean.getUsuarioTO().setEmail(null);
			bean.getUsuarioTO().setNome(null);
			bean.getUsuarioTO().setPermissao(null);
			bean.getUsuarioTO().setSenha(null);
			bean.getUsuarioTO().setBloco(null);
			bean.getUsuarioTO().setAp(null);
			bean.getUsuarioTO().setCargo(null);

			Perfil perfil = new Perfil("", "", "", 0, "", usuario.getNome(),
					"/WebHomeBeta/img/anonimos.jpg");
			perfilService.salvar(perfil);

			return new ModelAndView("cadastro", "bean", bean);
		}

		return new ModelAndView("cadastro", "bean", bean);

	}

	private void validarCadastro(UsuarioControllerBean bean) {

		if (!validator.isValidSenha(bean.getUsuarioTO().getSenha(),
				bean.getConfSenha())) {
			bean.setValidSenha(false);
			bean.setValidConfSenha(false);
		} else {
			bean.setValidSenha(true);
			bean.setValidConfSenha(true);
		}

		if (!validator.isValidNome(bean.getUsuarioTO().getNome()))
			bean.setValidName(false);
		else
			bean.setValidName(true);

		if (!validator.validaData(bean.getData()))
			bean.setValidDataNascimento(false);
		else
			bean.setValidDataNascimento(true);

		if (!validator.isCPF(bean.getUsuarioTO().getCpf()))
			bean.setValidCpf(false);
		else
			bean.setValidCpf(true);

		if (!validator.isValidEmail(bean.getUsuarioTO().getEmail()))
			bean.setValidEmail(false);
		else
			bean.setValidEmail(true);

		if (!validator.isValidApartamento(bean.getUsuarioTO().getAp()))
			bean.setValidApartamento(false);
		else
			bean.setValidApartamento(true);

		// for (Usuario user : usuarioService.getUsuario()) {
		// if (bean.getUsuarioTO().getBloco().equals(user.getBloco())) {
		// bean.setValidBloco(false);
		// }else{
		// bean.setValidBloco(true);
		// }
		// }
		// recebe uma lista do banco com todos os usuarios e verifica se o email
		// digitado ja existe no banco
		for (Usuario user : usuarioService.getUsuario()) {
			if (user.getEmail().equals(bean.getUsuarioTO().getEmail())) {
				bean.setValidEmailExistente(false);
			} else {
				bean.setValidEmailExistente(true);
			}

		}
	}

}
