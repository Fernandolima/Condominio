package br.com.webhomebeta.service.security;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import br.com.webhomebeta.entity.TentativaLogin;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.TentativaLoginService;
import br.com.webhomebeta.service.UsuarioService;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuthenticationFailureHandler extends
		SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TentativaLoginService loginService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@SuppressWarnings("deprecation")
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		if (exception.getClass()
				.isAssignableFrom(BadCredentialsException.class)) {

			Date dataAtual = new Date();

			String login = exception.getAuthentication().getName();

			TentativaLogin tentativaLogin = loginService.get(login);
			if (tentativaLogin == null) {
				TentativaLogin tLogin = new TentativaLogin();
				tLogin.setTentativas(1);
				tLogin.setNome(login);
				
				tLogin.setData(new Date(dataAtual.getTime() + 30 * 60 * 1000));
				loginService.save(tLogin);
				super.onAuthenticationFailure(request, response, exception);
			} else if (tentativaLogin.getTentativas() < 3) {
				tentativaLogin
						.setTentativas(tentativaLogin.getTentativas() + 1);
				loginService.update(tentativaLogin);
				super.onAuthenticationFailure(request, response, exception);
			} else if (tentativaLogin.getTentativas() == 3
					&& dataAtual.getTime() <= tentativaLogin.getData()
							.getTime()) {
				redirectStrategy.sendRedirect(request, response, "/erro");
			}
					
		} else if (exception.getClass().isAssignableFrom(
				DisabledException.class)) {

		} else if (exception.getClass().isAssignableFrom(
				AuthenticationException.class)) {

		}
	}

	@Scheduled(fixedRate = 60000)
	public void verificaExpiracao() {
		Date dataAtual = new Date();
		List<TentativaLogin> tentativaLogins = loginService.get();
		if (tentativaLogins != null) {
			for (TentativaLogin t : tentativaLogins) {
					if(dataAtual.getTime() > t.getData().getTime()){
						loginService.delete(t);
					}
			}
		}
	}
}
