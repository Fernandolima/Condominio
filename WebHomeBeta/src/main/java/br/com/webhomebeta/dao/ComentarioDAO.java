package br.com.webhomebeta.dao;

import br.com.webhomebeta.entity.Comentario;
import br.com.webhomebeta.entity.Publicacao;

public interface ComentarioDAO {
	
	public Comentario salvarComentario(Comentario comentario);
	public Comentario getComentarios(Publicacao publicacao);
	public Comentario getComentarios();
	public void update(int id, String imagem);
	
}
