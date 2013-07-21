package br.com.webhome.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.webhome.entity.Usuario;

public class MyAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		
		Usuario user = (Usuario)auth.getPrincipal();
		if(user.getPermissao() == "ROLE_ADMIN"){
			response.sendRedirect(request.getContextPath() + "/admin.jsp");
		}
		else if(user.getPermissao() == "ROLE_MORADOR"){
			
		}
		else{
			
		}
		
	}

}