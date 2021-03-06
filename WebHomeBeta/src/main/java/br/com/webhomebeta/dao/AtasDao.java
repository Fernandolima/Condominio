package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.AtasEntity;
//@Repository: as excecoes do JPA ser�o traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que n�o precisaremos tratar mensagens de erro do banco de dados

@Repository("atasDao")
public interface AtasDao {

	public AtasEntity save(AtasEntity atasEntity);

	public List<AtasEntity> getAtas( boolean ativa);
	
	public List<AtasEntity> getListAtas();
	
	public void update(int idAtas, boolean atasAtiva);
	
	public AtasEntity getidAtas(int id);
	
	public void updadeAtas(int id, String arquivo);
	
	public void updadeAtas(int id , String ata, String titulo, String alterada);

	public void delete(AtasEntity atasEntity);

}
