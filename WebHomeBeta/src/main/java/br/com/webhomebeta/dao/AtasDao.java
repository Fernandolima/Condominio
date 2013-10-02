package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.AtasEntity;
//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados

@Repository("atasDao")
public interface AtasDao {

	public AtasEntity save(AtasEntity atasEntity);

	public List<AtasEntity> getAtas();

	public AtasEntity getidAtas(int id);
	
	public void updadeAtas(int id , String ata);

	public void delete(AtasEntity atasEntity);

}
