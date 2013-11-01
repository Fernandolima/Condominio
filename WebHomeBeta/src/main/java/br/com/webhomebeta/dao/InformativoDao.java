package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.Informativo;

@Repository("informativoDao")
public interface InformativoDao {
	public Informativo save(Informativo informativo);

	public List<Informativo> getListInformativos();
	
	public List<Informativo> getListInformativos(int idUser);

	public Informativo getInformativo(int idInformativo);
	
	public void delete(Informativo informativo);

}
