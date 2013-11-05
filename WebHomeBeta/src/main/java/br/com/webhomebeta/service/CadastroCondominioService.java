
package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.DescricaoCondominioDAO;
import br.com.webhomebeta.entity.DescricaoCondominio;

@Service("cadastroCondominioService")
public class CadastroCondominioService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private DescricaoCondominioDAO daoCond;

	public DescricaoCondominio save(DescricaoCondominio descricaoCondominio) {

		return daoCond.save(descricaoCondominio);
	}

	public List<DescricaoCondominio> getDescricao() {

		return daoCond.getDescricaoCondominios();
	}

	public DescricaoCondominio editar(int id) {

		return (DescricaoCondominio) daoCond.editar(id);
	}

	public void update(DescricaoCondominio descricaoCondominio) {

		daoCond.update(descricaoCondominio);
	}

	public void delete(DescricaoCondominio descricaoCondominio) {
		daoCond.delete(descricaoCondominio);
	}
	
	public DescricaoCondominio get(int id){
		return daoCond.get(id);
	}
}