package br.com.webhomebeta.dao;

import br.com.webhomebeta.entity.Comentario;
import br.com.webhomebeta.entity.Publicacao;

public interface ComentarioDAO {
	
	public void salvarComentario(Comentario comentario);
	public Comentario getComentarios(Publicacao publicacao);
	public Comentario getComentarios();
	
}
