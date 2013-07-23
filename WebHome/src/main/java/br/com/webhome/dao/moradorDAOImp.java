package br.com.webhome.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhome.entity.Morador;

//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados
@Repository("moradorDao")
public class moradorDAOImp implements MoradorDAO {
	//@PersistenceContext: Realiza a injeção do entityManager que é responsável pelo CRUD
	@PersistenceContext
	protected EntityManager entityManager;

	//@Transactional: O spring se encarrega de criar uma nova transação
	@Transactional
	public Morador save(Morador morador) {
		entityManager.persist(morador);
		return morador;
	}

	@Transactional(readOnly = true)
	public Morador getMorador(int id) {
		String sql = "SELECT * FROM [dbo].[USER] WHERE ID = :id";
		Query query = entityManager.createQuery(sql);
		query.setParameter("id",id);
		Morador morador = (Morador) query.getSingleResult();
		
		return morador;
	}

	@Override
	public void remove(Morador morador) {

	}

	@Override
	public void update(Morador morador) {

	}

	@Override
	public List<Morador> getMoradores() {
		// TODO Auto-generated method stub
		return null;
	}

}
