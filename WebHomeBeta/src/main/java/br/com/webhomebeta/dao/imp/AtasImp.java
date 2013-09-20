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
	public AtasEntity save(AtasEntity atasEntity) {
		factory.getCurrentSession().save(atasEntity);
		return atasEntity;
	}

	@Transactional
	public AtasEntity editar(int id) {
		String sql = "exe[dbo].[ATAS] ?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(AtasEntity.class).setParameter(0, id);
		AtasEntity atasEntity = (AtasEntity) q.uniqueResult();
		return atasEntity;
	}
	@Transactional
	public void update(String arquivo) {
		Query q = factory.getCurrentSession().createSQLQuery("UPDATE [dbo].[ATAS] SET ARQUIVO = ?");
		q.setParameter(0, arquivo);
		q.executeUpdate();
	}
		@Transactional
		public void delete(AtasEntity atasEntity) {
		factory.getCurrentSession().delete(atasEntity);

	}

		@Transactional
		public List<AtasEntity> getAtas() {		
			String sql = "exe[dbo].[ATAS]";
			Query q = factory.getCurrentSession().createSQLQuery("SELECT  * FROM [dbo].[ATAS]");
			return q.list();
		
		}
		

}
