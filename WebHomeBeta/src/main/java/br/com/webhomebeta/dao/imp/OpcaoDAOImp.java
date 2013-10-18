package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.OpcaoDAO;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Opcao;

public class OpcaoDAOImp implements OpcaoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Opcao save(Opcao opcao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Opcao delete(Opcao opcao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Opcao getId(int id) {
		return (Opcao) sessionFactory.getCurrentSession()
				.createQuery("from Opcao e where e.idOpcao = ?")
				.setParameter(0, id).uniqueResult();

	}

	@Transactional
	public void update(int quantidadeVotos, int idOpcao) {
		Opcao opcao = (Opcao) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select new Opcao(e.quatVots) from Opcao e where e.idOpcao = ?")
				.setInteger(0, idOpcao);

		sessionFactory
				.getCurrentSession()
				.createQuery(
						"update Opcao e set e.quatVots = ? where e.idOpcao = ?")
				.setInteger(0, quantidadeVotos + opcao.getQuatVots())
				.setInteger(1, idOpcao).executeUpdate();

	}

	
}
