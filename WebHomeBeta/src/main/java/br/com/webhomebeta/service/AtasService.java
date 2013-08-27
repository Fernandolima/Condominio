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

	public AtasEntity save(AtasEntity atasEntity) {
		return atasDao.save(atasEntity);
	}

	public List<AtasEntity> getList() {
		return atasDao.getAtas();
	}
	
	public AtasEntity editar(int id){
		 return atasDao.editar(id);
	}
	
	public void delete(AtasEntity atasEntity){
	 atasDao.delete(atasEntity);
	 
	}
	
	public void update(AtasEntity atasEntity){
		atasDao.update(atasEntity);
	}

}