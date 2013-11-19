package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.UsuarioDAO;

import br.com.webhomebeta.entity.Usuario;


public class UsuarioService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private UsuarioDAO usuarioDao;

	public Usuario save(Usuario usuario) {

		return usuarioDao.save(usuario);
	}

	public List<Usuario> getUsuario() {

		return usuarioDao.getUsuario();
	}

	public List<Usuario> getUsuarioNaoAtivo() {

		return usuarioDao.getUsuarioNaoAtivo();
	}

	public Usuario getUsuarioByLogin(String login) {

		return usuarioDao.getUsuarioByLogin(login);
	}

	public void update(Usuario usuario) {

		usuarioDao.update(usuario);
	}

	public long getRowCount(boolean b) {
		return usuarioDao.getRowCount(b);
	}

	public Usuario getById(int id) {
		return usuarioDao.getById(id);
	}

	public void evitcCache() {
		usuarioDao.evictCache();
	}

	public void update(int id, boolean b) {
		usuarioDao.update(id, b);
	}

	public Usuario getByCargo(String cargo) {
		return usuarioDao.getByCargo(cargo);
	}

	public void update(int idUser, String senha) {
		usuarioDao.update(idUser, senha);
	}

	public List<Usuario> getListAtiva(boolean usuario) {
		return usuarioDao.getLisAtivo(usuario);
	}
	public Usuario getId(int id) {
		return usuarioDao.getId(id);
	}
	
	public Usuario getImg(int id){
		return usuarioDao.getImg(id);
	}
}