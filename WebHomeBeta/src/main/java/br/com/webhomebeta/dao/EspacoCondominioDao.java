package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.EspacoCondominio;

//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados
@Repository("espacoCondominioDao")
public interface EspacoCondominioDao {
	
	public EspacoCondominio save(EspacoCondominio espacoCondominio);
	
	public void saveEspaco(EspacoCondominio espacoCondominio);

	public void update(EspacoCondominio condominio);

	public void delete(EspacoCondominio espacoCondominio);
	
	public EspacoCondominio get(int idEspaco);
	
	public List<EspacoCondominio> getLisEspacoCondominios();
	

}
