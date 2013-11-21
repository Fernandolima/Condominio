package br.com.webhomebeta.service.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.entity.TentativaLogin;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.TentativaLoginService;
import br.com.webhomebeta.service.UsuarioService;

//Servico de autenticacao
@Service("customLogin")
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TentativaLoginService loginService;
	// Cria os roles
	private GrantedAuthority authorityAdmin = new GrantedAuthorityImp(
			"ROLE_ADMIN");
	private GrantedAuthority authorityMorador = new GrantedAuthorityImp(
			"ROLE_MORADOR");
	private GrantedAuthority authorityFunc = new GrantedAuthorityImp(
			"ROLE_FUNC");
	private Set<GrantedAuthority> authoritiesAdmin = new HashSet<GrantedAuthority>();
	private Set<GrantedAuthority> authoritiesMorador = new HashSet<GrantedAuthority>();
	private Set<GrantedAuthority> authoritiesFunc = new HashSet<GrantedAuthority>();
	private Usuario usuario;
    private UserDetails user;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException, BadCredentialsException  {
		authoritiesAdmin.add(authorityAdmin);
		authoritiesMorador.add(authorityMorador);
		authoritiesFunc.add(authorityFunc);
		
		usuario = usuarioService.getUsuarioByLogin(username);
		
		List<TentativaLogin> tentativaLogins = loginService.get();
		for(TentativaLogin login : tentativaLogins){
			if(username.equals(login.getNome())){
				throw new UsernameNotFoundException("Usuario nao encontrado");
			}
		}
		
		if (usuario == null || usuario.isStatus() == false) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		} else if (usuario.getPermissao().equals("ROLE_ADMIN")) {
			
			user = new UserDetailsImp(usuario.getSenha(), usuario.getLogin(),
					authoritiesAdmin);
		} else if (usuario.getPermissao().equals("ROLE_MORADOR")){
			user = new UserDetailsImp(usuario.getSenha(), usuario.getLogin(),authoritiesMorador);
		} else {
			user = new UserDetailsImp(usuario.getSenha(), usuario.getLogin(),authoritiesFunc);
		}
		return user;
	}

}
