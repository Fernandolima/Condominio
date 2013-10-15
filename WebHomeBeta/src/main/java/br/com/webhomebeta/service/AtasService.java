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

	public List<AtasEntity> getList(boolean ativa) {
		return atasDao.getAtas(ativa);
	}
	
	public List<AtasEntity> getListAtas() {
		return atasDao.getListAtas();
	}
	
	

	public AtasEntity getidAtas(int id) {
		return atasDao.getidAtas(id);
	}

	public void updateAtas(int id, String ata, String titulo) {
		 atasDao.updadeAtas(id, ata, titulo);
	}

	public void  updateFalse(int idAtas, boolean atasAtivas) {
		atasDao.update(idAtas, atasAtivas);
		
	}
	public void delete(AtasEntity atasEntity) {
		atasDao.delete(atasEntity);

	}

}
