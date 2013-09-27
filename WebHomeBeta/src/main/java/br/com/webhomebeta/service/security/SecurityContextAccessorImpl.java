package br.com.webhomebeta.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityContextAccessorImpl implements SecurityContextAcessor {

	@Autowired
	private AuthenticationTrustResolver authenticationTrustResolver;

	@Override
	public boolean isConectadoAnonimamente() {
		final Authentication authentication = SecurityContextHolder
				.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

}
