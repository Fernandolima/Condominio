package br.com.webhomebeta.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.MoradorDAO;
import br.com.webhomebeta.entity.Morador;
import br.com.webhomebeta.to.MoradorTO;

//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados
@Repository("moradorDao")
public class MoradorDAOImp implements MoradorDAO {
	//@PersistenceContext: Realiza a injeção do entityManager que é responsável pelo CRUD
	@PersistenceContext
	protected EntityManager entityManager;
	
	//@Transactional: O spring se encarrega de criar uma nova transação
	@Transactional
	public MoradorTO save(Morador morador) {
		entityManager.persist(morador);
		MoradorTO moradorTO = new MoradorTO();
		BeanUtils.copyProperties(morador, moradorTO);
		return moradorTO;
	}
	//Pega o morador pelo login
	public MoradorTO getMorador(String login){
		String sql = "SELECT * FROM [dbo].[USER] WHERE LOGIN = :login";
		Query query = entityManager.createQuery(sql);
		query.setParameter("login",login);
		Morador morador = (Morador) query.getSingleResult();
		MoradorTO moradorTO = new MoradorTO();
		BeanUtils.copyProperties(morador, moradorTO);
		return moradorTO;
	}

	@Transactional(readOnly = true)
	public MoradorTO getMorador(int id) {
		String sql = "SELECT * FROM [dbo].[USER] WHERE ID = :id";
		Query query = entityManager.createQuery(sql);
		query.setParameter("id",id);
		Morador morador = (Morador) query.getSingleResult();
		MoradorTO moradorTO = new MoradorTO();
		BeanUtils.copyProperties(morador, moradorTO);
		return moradorTO;
	}

	@Override
	public void remove(Morador moradorTO) {

	}

	@Override
	public void update(Morador moradorTO) {
		entityManager.merge(moradorTO);
	}

	@Override
	public List<MoradorTO> getMoradores() {
		// TODO Auto-generated method stub
		return null;
	}

}
