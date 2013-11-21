package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.TentativaLogin;

public interface TentativaLoginDAO {

	public TentativaLogin save(TentativaLogin login);
	public void delete(TentativaLogin login);
	public void update(TentativaLogin login);
	public TentativaLogin get(String nome);
	public List<TentativaLogin> get();
}
