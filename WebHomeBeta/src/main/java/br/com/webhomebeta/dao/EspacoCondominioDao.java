package br.com.webhomebeta.dao;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.EspacoCondominio;

//@Repository: as excecoes do JPA ser�o traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que n�o precisaremos tratar mensagens de erro do banco de dados
@Repository("espacoCondominioDao")
public interface EspacoCondominioDao {
	
	public void save(EspacoCondominio espacoCondominio);

	public void update(EspacoCondominio condominio);

	public void delete(EspacoCondominio espacoCondominio);

}
