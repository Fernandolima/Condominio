package br.com.webhomebeta.dao.imp;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.sql.Update;
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
		String sql = "exec [dbo].[USUARIO_CRIPTOGRAFADO_I] ?,?,?,?,?,?,?,?,?,?,?,?,?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Usuario.class);
		q.setParameter(0, usuario.getBloco());
		q.setParameter(1, usuario.getAp());
		q.setParameter(2, usuario.getCargo());
		q.setParameter(3, usuario.getDt_nascimento());
		q.setParameter(4, usuario.getPermissao());
		q.setParameter(5, usuario.getEmail());
		q.setParameter(6, usuario.getNome());
		q.setParameter(7, usuario.getCpf());
		q.setParameter(8, usuario.getLogin());
		q.setParameter(9, usuario.getSenha());
		q.setParameter(10, usuario.isStatus());
		q.setParameter(11, usuario.getImagem());
		q.setParameter(12, usuario.getImagemView());

		q.executeUpdate();

		return usuario;
	}

	@Transactional
	public List<Usuario> getUsuario() {
		String sql = "exec [dbo].[USUARIOS_DESCRIPTOGRAFADO_ALL]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Usuario.class);
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = q.list();
		return usuarios;
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

	@Override
	@Transactional
	public void update(Usuario usuario) {

		Query q = factory
				.getCurrentSession()
				.createSQLQuery(
						"UPDATE [dbo].[USER] SET IMAGEM = ?, IMAGEM_VIEW = ? WHERE ID_USER = ?");
		q.setParameter(0, usuario.getImagem());
		q.setParameter(1, usuario.getImagemView());
		q.setParameter(2, usuario.getIdUser());
		q.executeUpdate();
	}

	@Override
	@Transactional
	public Usuario getById(int id) {

		Query q = factory.getCurrentSession().createQuery(
				"select new Usuario(u.nome) from Usuario u where u.idUser = ?");
		q.setInteger(0, id);
		return (Usuario) q.uniqueResult();

	}

	public void evictCache() {

		factory.getCache().evictEntityRegions();

	}

	@Override
	@Transactional
	public Integer getRowCount(boolean b) {
		return (Integer) factory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("STATUS", b))
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	@Transactional
	public void update(int id, boolean b) {
		Query q = factory.getCurrentSession().createQuery(
				"update Usuario u where u.idUser = ? and u.status = ?");
		q.setInteger(0, id);
		q.setBoolean(1, b);
		q.executeUpdate();
	}

	@Override
	@Transactional
	public Usuario getByCargo(String cargo) {
		return (Usuario) factory.getCurrentSession()
				.createQuery("from Usuario u where u.cargo = ?")
				.setString(0, cargo).uniqueResult();
	}

	@Override
	@Transactional
	public void update(String senha, int idUser) {

		factory.getCurrentSession().createSQLQuery("exec [dbo].[] ? ?")
				.setString(0, senha).setInteger(1, idUser).executeUpdate();

	}

}
