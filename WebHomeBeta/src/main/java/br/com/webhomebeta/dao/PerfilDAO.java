package br.com.webhomebeta.dao;

import br.com.webhomebeta.entity.Perfil;

public interface PerfilDAO {

	public Perfil salvar(Perfil perfil);
	public void update(Perfil perfil);
	public void remover(Perfil perfil);
	public Perfil get(int idPerfil);
}
