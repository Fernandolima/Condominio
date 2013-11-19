package br.com.webhomebeta.service.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
			
	private ObjectMapper mapper = new ObjectMapper();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
	  
	  if(exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
		  System.out.println("UHAUHUAHUAHUAHUAHUAHUAHUA NAO ENCONTROU O USERNAME");
		  redirectStrategy.sendRedirect(request, response, "/erro");
	  } else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
	    
	  } else if (exception.getClass().isAssignableFrom(AuthenticationException.class)){
		  
	  }
	}
}
