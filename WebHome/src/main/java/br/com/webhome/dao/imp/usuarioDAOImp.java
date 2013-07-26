package br.com.webhome.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhome.entity.Morador;
import br.com.webhome.to.MoradorTO;


//@Repository: as excecoes do JPA ser�o traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que n�o precisaremos tratar mensagens de erro do banco de dados
@Repository("usuarioDao")
public class usuarioDAOImp {
	//@PersistenceContext: Realiza a inje��o do entityManager que � respons�vel pelo CRUD
		@PersistenceContext
		protected EntityManager entityManager;
		
		//@Transactional: O spring se encarrega de criar uma nova transa��o
		@Transactional
		public UsuarioTO save(Usuario usuario) {
			entityManager.persist(morador);
			MoradorTO moradorTO = new MoradorTO();
			BeanUtils.copyProperties(morador, moradorTO);
			return moradorTO;
		}
		//Pega o morador pelo login
		public UsuarioTO getMorador(String login){
			String sql = "SELECT * FROM [dbo].[USER] WHERE LOGIN = :login";
			Query query = entityManager.createQuery(sql);
			query.setParameter("login",login);
			Morador morador = (Morador) query.getSingleResult();
			MoradorTO moradorTO = new MoradorTO();
			BeanUtils.copyProperties(morador, moradorTO);
			return moradorTO;
		}

		@Transactional(readOnly = true)
		public UsuarioTO getMorador(int id) {
			String sql = "SELECT * FROM [dbo].[USER] WHERE ID = :id";
			Query query = entityManager.createQuery(sql);
			query.setParameter("id",id);
			Morador morador = (Morador) query.getSingleResult();
			MoradorTO moradorTO = new MoradorTO();
			BeanUtils.copyProperties(morador, moradorTO);
			return moradorTO;
		}

		
		@Override
		public List<UsuarioTO> getMoradores() {
			// TODO Auto-generated method stub
			return null;
		}

}
