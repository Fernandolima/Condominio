package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.VisitanteDao;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.entity.Visitante;

public class VisitanteImp implements VisitanteDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public Visitante save(Visitante visitante) {
		factory.getCurrentSession().save(visitante);
		return visitante;
	}

	@Transactional
	public void delete(Visitante visitante) {
		factory.getCurrentSession().delete(visitante);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> getLit(String bloco, String ap) {
		return (List<Usuario>) factory
				.getCurrentSession()
				.createSQLQuery(
						"SELECT * FROM DBO.USER WHERE AP = ? AND BLOCO = ?")
				.addEntity(Usuario.class).setParameter(0, ap)
				.setParameter(1, bloco).list();
	}

	@Transactional
	public List<Visitante> getListVis() {
		Query q = factory
				.getCurrentSession()
				.createSQLQuery(
						"SELECT * FROM VISITANTE ORDER BY DATA_VISITANTE DESC")
				.addEntity(Visitante.class);
		@SuppressWarnings("unchecked")
		List<Visitante> visitantesI = q.list();
		return visitantesI;
	}

}
