package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.UsuarioDAO;

import br.com.webhomebeta.entity.Usuario;

@Service("usuarioService")
public class UsuarioService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private UsuarioDAO dao;

	public Usuario save(Usuario usuario) {

		return dao.save(usuario);
	}

	public List<Usuario> getUsuario() {

		return dao.getUsuario();
	}

	public List<Usuario> getUsuarioNaoAtivo() {

		return dao.getUsuarioNaoAtivo();
	}

	public Usuario getUsuarioByLogin(String login) {
		
		return dao.getUsuarioByLogin(login);
	}
	
	public void update(Usuario usuario){
		
		dao.update(usuario);
	}
	
}