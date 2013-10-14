package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.MuralDAO;
import br.com.webhomebeta.entity.Mural;

public class MuralService {
	
	@Autowired
	private MuralDAO muralDAO;
	
	public Mural save(Mural mural){
		return muralDAO.save(mural);
	}
	
	public void delete(Mural mural){
		muralDAO.delete(mural);
	}
	
	public Mural get(int idMural){
		return muralDAO.get(idMural);
	}

	public List<Mural> getList(){
		return muralDAO.getList();
	}
	
	public void update(Mural mural){
		muralDAO.update(mural);
	}
}
