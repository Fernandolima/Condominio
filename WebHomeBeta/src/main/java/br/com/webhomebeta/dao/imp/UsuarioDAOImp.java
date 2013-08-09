package br.com.webhomebeta.dao.imp;

import java.beans.Transient;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.UsuarioDAO;
import br.com.webhomebeta.entity.Morador;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.MoradorTO;
import br.com.webhomebeta.to.UsuarioTO;


//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados
@Repository("usuarioDao")
public class UsuarioDAOImp  implements  UsuarioDAO {
	//@PersistenceContext: Realiza a injeção do entityManager que é responsável pelo CRUD
		@PersistenceContext
		protected EntityManager entityManager;
		
		//@Transactional: O spring se encarrega de criar uma nova transação
		@Transactional
		public Usuario save(Usuario usuario) {
			entityManager.persist(usuario);
			
			return usuario;
		}
		
		@Transactional
		public List<Usuario> getUsuario() {
			//String sqloracle = SELECT p FROM pessoas p
			String sql = "SELECT * FROM [dbo].[User]";
			Query query = entityManager.createNativeQuery(sql, Usuario.class );
			List<Usuario> usuario = query.getResultList();
			
			return usuario;
		}

		
		

}
