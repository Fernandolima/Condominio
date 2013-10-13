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
		  public Usuario getById(int id);
		  public void evictCache();
		  public long getRowCount(boolean b);
		  public void update(int id, boolean b);
		  public Usuario getByCargo(String cargo);
		  public void update(int idUser, String senha);
		  public List<Usuario> getLisAtivo(boolean ativo);
		  
	}


