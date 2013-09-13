package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Usuario;

public interface UsuarioDAO {
	

		  public Usuario save(Usuario usuario);
		   // public Morador getMorador(int id);
		   // public UsuarioTO getUsurio(String login);
		  public List<Usuario> getUsuario();
		  public List<Usuario> getUsuarioNaoAtivo();
		  public Usuario getUsuarioByLogin(String login);
		  public void update(Usuario usuario);
		  
	}


