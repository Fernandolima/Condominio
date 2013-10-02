package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.AtasDao;
import br.com.webhomebeta.entity.AtasEntity;

@Service("atasService")
public class AtasService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private AtasDao atasDao;

	public void save(AtasEntity atasEntity) {
		atasDao.save(atasEntity);
	}

	public List<AtasEntity> getList() {
		return atasDao.getAtas();
	}

	public AtasEntity getidAtas(int id) {
		return atasDao.getidAtas(id);
	}

	public void updateAtas(int id, String ata) {
		 atasDao.updadeAtas(id, ata);
	}

	public void delete(AtasEntity atasEntity) {
		atasDao.delete(atasEntity);

	}

}
