package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.UsuarioDAO;
import br.com.webhomebeta.entity.Usuario;

//@Repository: as excecoes do JPA serão traduzidas em excecoes do tipo DataAccessException do Spring, 
//o que significa que não precisaremos tratar mensagens de erro do banco de dados
@Repository("usuarioDao")
public class UsuarioDAOImp implements UsuarioDAO {
	
	@Autowired
	private SessionFactory factory;

	@Transactional
	public Usuario save(Usuario usuario) {
		factory.getCurrentSession().persist(usuario);
		return usuario;
	}

	@Transactional
	public List<Usuario> getUsuario() {

		return null;
	}

	@Transactional
	public List<Usuario> getUsuarioNaoAtivo() {
		String sql = "exec [dbo].[USUARIOS_DESCRIPTOGRAFADO_STATUS_FALSO]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Usuario.class);
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = q.list();
		return usuarios;
	}

	@Transactional
	public Usuario getUsuarioByLogin(String login) {
		String sql = "exec [dbo].[Usuarios] :login";

		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Usuario.class)
				.setParameter("login", login);
		Usuario usuario = (Usuario) q.uniqueResult();

		return usuario;
	}

}
