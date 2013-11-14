package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.webhomebeta.dao.VisitanteDao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.entity.Visitante;

@Service("usuarioService")
public class VisitanteService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private VisitanteDao dao;

	public Visitante save(Visitante visitante) {
		return dao.save(visitante);
	}

	public void delete(Visitante visitante) {
		dao.delete(visitante);

	}

	public List<Usuario> getList(String bloco, String ap) {
		return dao.getLit(bloco, ap);
	}

	public List<Visitante> getVisitantes() {
		return dao.getListVis();
	}
}
