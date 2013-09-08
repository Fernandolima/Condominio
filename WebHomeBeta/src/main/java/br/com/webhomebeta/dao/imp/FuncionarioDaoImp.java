package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.FuncionarioDao;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Funcionario;

public class FuncionarioDaoImp implements FuncionarioDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(Funcionario funcionario) {
		factory.getCurrentSession().save(funcionario);

	}

	@Transactional
	public void editar(Funcionario funcionario) {
		factory.getCurrentSession().update(funcionario);

	}

	@Transactional
	public void delete(Funcionario funcionario) {
		factory.getCurrentSession().delete(funcionario);

	}

	@Override
	public Funcionario getFuncinario(int id) {
		return (Funcionario) factory.getCurrentSession().load(
				Funcionario.class, id);

	}

	@Transactional
	public List<Funcionario> getListFuncionairo() {

		String sql = "exe[dbo].[FUNCIONARIO]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Funcionario.class);
		@SuppressWarnings("unchecked")
		List<Funcionario> funcionarios = q.list();
		return funcionarios;

	}
}
