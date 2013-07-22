package br.com.webhome.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.webhome.entity.Usuario;

@ManagedBean
@SessionScoped // Isto mantem o contexto do usuario logado at� o fim de sua sess�o
public class UsuarioController implements Serializable {
	
	private Usuario usuario;
	
	
	public UsuarioController(){
		usuario = new Usuario(); //Cria novo usu�rio
		SecurityContext context = SecurityContextHolder.getContext();//Recebe o contexto do usuario que logou
		if(context instanceof SecurityContext){
			Authentication authentication = context.getAuthentication();
			if(authentication instanceof Authentication){
				usuario.setNome(((User)authentication.getPrincipal()).getUsername()); //pega o nome do usuario
			}
		}
	}
}
