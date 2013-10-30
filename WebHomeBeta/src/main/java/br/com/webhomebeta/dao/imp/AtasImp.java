package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.AtasDao;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Usuario;

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
		Query q = factory.getCurrentSession().createSQLQuery(
				"UPDATE [dbo].[ATAS] SET ARQUIVO = ?");
		q.setParameter(0, arquivo);
		q.executeUpdate();
	}

	@Transactional
	public void delete(AtasEntity atasEntity) {
		factory.getCurrentSession().delete(atasEntity);

	}

	// traz todos as atas ativas = true
	@SuppressWarnings("unchecked")
	@Transactional
	public List<AtasEntity> getAtas(boolean ativa) {
		Query q = factory.getCurrentSession().createSQLQuery("SELECT * FROM ATAS WHERE  ATAS_ATIVA = ?").addEntity(AtasEntity.class);
		return q.setBoolean(0, ativa).list();

	}

	@Transactional
	public AtasEntity getidAtas(int id) {
		Query q = factory.getCurrentSession()
				.createSQLQuery("SELECT * FROM [dbo].[ATAS] WHERE ID_ATAS = ?")
				.addEntity(AtasEntity.class);
		q.setParameter(0, id);
		return (AtasEntity) q.uniqueResult();

	}

	@Transactional
	public void updadeAtas(int id, String arquivo) {
		Query q = factory
				.getCurrentSession()
				.createSQLQuery(
						"UPDATE [dbo].[ATAS] SET ARQUIVO = ? WHERE ID_ATAS = ? ")
				.addEntity(AtasEntity.class);
		q.setString(0, arquivo);
		q.setInteger(1, id);
		q.executeUpdate();

		// tem que ter um retorno
	}

	@Override
	@Transactional
	public void update(int idAtas, boolean atasAtiva) {
		Query q = factory
				.getCurrentSession()
				.createSQLQuery(
						"UPDATE [dbo].[ATAS] SET ATAS_ATIVA = ? WHERE ID_ATAS = ?")
				.addEntity(AtasEntity.class);
		q.setInteger(0, idAtas);
		q.setBoolean(1, atasAtiva);
		q.executeUpdate();
	}

	@Transactional
	public List<AtasEntity> getListAtas() {
		Query q = factory.getCurrentSession().createSQLQuery("SELECT * FROM ATAS ORDER BY DATA_FORMAT DESC").addEntity(AtasEntity.class);
		@SuppressWarnings("unchecked")
		List<AtasEntity> atas = q.list();
		return atas;
	}

	@Override
	@Transactional
	public void updadeAtas(int id, String ata, String titulo, String alterada) {
		Query q = factory
				.getCurrentSession()
				.createSQLQuery(
						"UPDATE [dbo].[ATAS] SET ATAS = ? , TITULO = ?, ALTERADAS = ? WHERE ID_ATAS = ? ")
				.addEntity(AtasEntity.class);
		q.setString(0, ata);
		q.setString(1, titulo);
		q.setString(2, alterada);
		q.setInteger(3, id);
		q.executeUpdate();
		
	}

}
