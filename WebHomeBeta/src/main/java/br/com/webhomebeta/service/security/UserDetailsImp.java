package br.com.webhomebeta.service.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//Usada no Spring security para autenticar o usuario
public class UserDetailsImp implements UserDetails {
	
	private Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	 private String senha;
	 private String login;
	 
	public UserDetailsImp(String senha, String login, Collection<GrantedAuthority> authorities) {
		this.senha = senha;
		this.login = login;
		this.authorities = authorities;
	}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

