package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

public class AuthenticatedController {
	
	private Usuario usuarioNaSessao;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Usuario obterUsuarioLogado() {
		//Pega o contexto do spring security
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			//Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				//Pega o usuario que logou
				usuarioNaSessao = usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername());

			}
		}
		
		return usuarioNaSessao;
	}
}
