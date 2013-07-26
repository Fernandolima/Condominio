package br.com.webhome.dao;

import java.util.List;

import br.com.webhome.entity.Usuario;
import br.com.webhome.to.UsuarioTO;

public class UsuarioDAO {

	  public UsuarioTO save(Usuario usuario);
	   // public Morador getMorador(int id);
	   // public UsuarioTO getUsurio(String login);
	    public List<UsuarioTO> getUsuario();
	  
}
