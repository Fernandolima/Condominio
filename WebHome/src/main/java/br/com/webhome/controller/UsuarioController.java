package br.com.webhome.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.webhome.entity.Usuario;
import br.com.webhome.to.UsuarioTO;

@ManagedBean
@SessionScoped // Isto mantem o contexto do usuario logado até o fim de sua sessão
public class UsuarioController implements Serializable {
	
	private UsuarioTO usuario;
	
	public UsuarioController(){
		
	}
}
//Pega o user que logou