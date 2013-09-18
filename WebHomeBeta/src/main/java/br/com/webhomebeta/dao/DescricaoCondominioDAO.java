
package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.DescricaoCondominio;

//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados
@Repository("DescricaoCondominioDao")
public interface DescricaoCondominioDAO {

	public DescricaoCondominio save(DescricaoCondominio descricaoCondominio);

	public List<DescricaoCondominio> getDescricaoCondominios();
	
	public DescricaoCondominio editar(int id);
	
	public int get(DescricaoCondominio condominio);
	
	public void update(DescricaoCondominio descricaoCondominio);
	
	public  void delete(DescricaoCondominio descricacoCondominio);
}