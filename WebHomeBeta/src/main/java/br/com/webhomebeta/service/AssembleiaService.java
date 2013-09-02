package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.AssembleiaDao;
import br.com.webhomebeta.entity.Assembleia;

@Service("assembleiaService")
public class AssembleiaService {

	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private AssembleiaDao assembleiaDao;

	public void save(Assembleia assembleia) {
		assembleiaDao.save(assembleia);
	}

	public List<Assembleia> getList() {
		return assembleiaDao.getAssembleias();
	}

	public Assembleia editar(int id) {
		return assembleiaDao.editar(id);
	}

	public void delete(Assembleia assembleia) {
		assembleiaDao.delete(assembleia);

	}

	public void update(Assembleia assembleia) {
		assembleiaDao.update(assembleia);
	}

}
