package br.com.webhomebeta.dao;

import br.com.webhomebeta.entity.NaoGostou;

public interface NaoGostouDAO {

	public NaoGostou salvar(NaoGostou naoGostou);
	public void delete(NaoGostou naoGostou);
	public NaoGostou get(int id);
}
