package br.com.webhomebeta.dao;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;

public interface PublicacaoDAO {
	
	public Publicacao salvarPublicacao(Publicacao publicacao);
	public void deletarPublicacao(int idUsuario, int idPublicacao);
	public List<Publicacao> getPublicacoes(int colunaInicial, int tamanhoColuna);
	public List<Publicacao> getPublicacao(int idUser);
	public Publicacao getUnicaPublicacao(int idPublicacao);
	public void update(int id, String imagem);
	public void delete(Publicacao p);
	public long getRowCount();
}
		
	

