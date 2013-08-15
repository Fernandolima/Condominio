package br.com.webhomebeta.service.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;

//Servico de autenticacao
@Service("customLogin")
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private UsuarioService usuarioService;
	// Cria os roles
	private GrantedAuthority authorityAdmin = new GrantedAuthorityImp(
			"ROLE_ADMIN");
	private GrantedAuthority authorityMorador = new GrantedAuthorityImp(
			"ROLE_MORADOR");
	private Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	private Usuario usuario;
    private UserDetails user;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		usuario = usuarioService.getUsuarioByLogin(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		} else if (usuario.getPermissao().equals("ROLE_ADMIN")) {
			authorities.add(authorityAdmin);
			user = new UserDetailsImp(usuario.getSenha(), usuario.getLogin(),
					authorities);
		}
		return user;
	}

}
