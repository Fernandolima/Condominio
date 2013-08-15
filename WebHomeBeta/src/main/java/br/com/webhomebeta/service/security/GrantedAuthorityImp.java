package br.com.webhomebeta.service.security;

import org.springframework.security.core.GrantedAuthority;
//Usada no Spring Security para garantir permissoes de acesso
public class GrantedAuthorityImp implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String role;
	public GrantedAuthorityImp(String role){
		this.role = role;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role;
	}

}
