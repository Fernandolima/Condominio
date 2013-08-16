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
		String sql = "exec [dbo].[USUARIO_CRIPTOGRAFADO_I] ?,?,?,?,?,?,?,?,?,?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Usuario.class);
		q.setParameter(0, usuario.getBlocoEAp());
		q.setParameter(1, usuario.getCargo());
		q.setParameter(2, usuario.getDt_nascimento());
		q.setParameter(3, usuario.getPermissao());
		q.setParameter(4, usuario.getEmail());
		q.setParameter(5, usuario.getNome());
		q.setParameter(6, usuario.getCpf());
		q.setParameter(7, usuario.getLogin());
		q.setParameter(8, usuario.getSenha());
		q.setParameter(9, usuario.isStatus());

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
		String sql = "exec [dbo].[USUARIOS_DESCRIPTOGRAFADO_LOGIN] :login";

		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Usuario.class).setParameter("login", login);
		Usuario usuario = (Usuario) q.uniqueResult();

		return usuario;
	}

}
