package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.EspacoCondominioDao;
import br.com.webhomebeta.entity.EspacoCondominio;

@Service("espacoCondominioService")
public class EspacoCondominioServe {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	public EspacoCondominioDao condominioDao;

	public void save(EspacoCondominio condominio) {
		condominioDao.save(condominio);
	}

	public void update(EspacoCondominio espacoCondominio) {
		condominioDao.update(espacoCondominio);

	}

	public void delete(EspacoCondominio espacoCondominio) {
		condominioDao.delete(espacoCondominio);
	}
	
	public List<EspacoCondominio> getLisEspacoCondominios() {
		return condominioDao.getLisEspacoCondominios();
		
	}

}
