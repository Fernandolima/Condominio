package br.com.webhome.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.webhome.entity.Usuario;

@ManagedBean
@SessionScoped // Isto mantem o contexto do usuario logado até o fim de sua sessão
public class UsuarioController implements Serializable {
	
	private Usuario usuario;
	
	
	public UsuarioController(){
		usuario = new Usuario(); //Cria novo usuário
		SecurityContext context = SecurityContextHolder.getContext();//Recebe o contexto do usuario que logou
		if(context instanceof SecurityContext){
			Authentication authentication = context.getAuthentication();
			if(authentication instanceof Authentication){
				usuario.setNome(((Usuario)authentication.getPrincipal()).getNome()); //pega o nome do usuario
			}
		}
	}
}
