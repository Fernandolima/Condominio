package br.com.webhomebeta.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import br.com.webhomebeta.service.UsuarioService;

public class DaoAuthenticationProviderLimiter extends DaoAuthenticationProvider {
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
      // Could assert pre-conditions here, e.g. rate-limiting
      // and throw a custom AuthenticationException if necessary

      try {
        return super.authenticate(authentication);
      } catch (BadCredentialsException e) {
        // Will throw a custom exception if too many failed logins have occurred
    	  System.out.println("AUIDSHAUIHDUAIHDIUAGHDIUAGDUIAGDIUAGDAUISGDIUAGDIUAGDUIAGUDIGDUIGASIUDAUSIGDIUASGDIUAGDIASGUDGU");
        throw e;
      }
   }
	
}
