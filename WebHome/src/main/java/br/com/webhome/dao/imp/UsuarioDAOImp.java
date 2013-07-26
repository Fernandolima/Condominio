package br.com.webhome.dao.imp;

import java.beans.Transient;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhome.dao.UsuarioDAO;
import br.com.webhome.entity.Morador;
import br.com.webhome.entity.Usuario;
import br.com.webhome.to.MoradorTO;
import br.com.webhome.to.UsuarioTO;


//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados
@Repository("usuarioDao")
public class UsuarioDAOImp  implements  UsuarioDAO {
	//@PersistenceContext: Realiza a injeção do entityManager que é responsável pelo CRUD
		@PersistenceContext
		protected EntityManager entityManager;
		
		//@Transactional: O spring se encarrega de criar uma nova transação
		@Transactional
		public UsuarioTO save(Usuario usuario) {
			entityManager.persist(usuario);
			MoradorTO moradorTO = new MoradorTO();
			BeanUtils.copyProperties(usuario, moradorTO);
			return moradorTO;
		}

		@Transactional
		public List<UsuarioTO> getUsuario() {
			// TODO Auto-generated method stub
			return null;
		}

		
		

}
