package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.InformativoDao;
import br.com.webhomebeta.entity.Informativo;

@Service("informativoService")
public class InformativoService {

	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private InformativoDao informativoDao;

	public void save(Informativo informativo) {
		informativoDao.save(informativo);
	}

	public List<Informativo> getList() {
		return informativoDao.getListInformativos();
	}

	public void delete(Informativo informativo) {
		informativoDao.delete(informativo);
	}

}
