package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.AtasDao;
import br.com.webhomebeta.entity.AtasEntity;

public class AtasImp implements AtasDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public AtasEntity inseri(AtasEntity atasEntity) {
		String sql = "exec [dbo].[ATAS_CONDOMINIO_I] ?,?,?,?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(AtasEntity.class);
		q.setParameter(0, atasEntity.getIdAtas());
		q.setParameter(1, atasEntity.getUsuarioAtas());
		q.setParameter(2, atasEntity.getComentario());
		q.setParameter(3, atasEntity.getDataCriacao());

		q.executeUpdate();

		return atasEntity;
	}

	@Transactional
	public List<AtasEntity> getAtasEntities() {
		String sql = "exe[dbo].[ATAS]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(AtasEntity.class);
		@SuppressWarnings("unchecked")
		List<AtasEntity> atasEntities = q.list();
		return atasEntities;

	}

	@Override
	public AtasEntity save(AtasEntity atasEntity) {
		factory.getCurrentSession().save(atasEntity);
		return atasEntity;
	}

	@Override
	public AtasEntity editar(int id) {
		String sql = "exe[dbo].[ATAS] ?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(AtasEntity.class).setParameter(0, id);
		AtasEntity atasEntity = (AtasEntity) q.uniqueResult();
		return atasEntity;
	}

	public void update(AtasEntity atasEntity) {
		factory.getCurrentSession().update(atasEntity);

	}

	@Override
	public List<AtasEntity> getAtas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(AtasEntity atasEntity) {
		factory.getCurrentSession().delete(atasEntity);

	}

}
