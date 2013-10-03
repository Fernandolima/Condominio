package br.com.webhomebeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.ComentarioDAO;
import br.com.webhomebeta.entity.Comentario;

@Service("comentarioService")
public class ComentarioService {
	@Autowired
	private ComentarioDAO comentarioDAO;

	public Comentario save(Comentario comentario) {
		return comentarioDAO.salvarComentario(comentario);
	}
	
	public void update(int id, String imagem){
		comentarioDAO.update(id, imagem);
	}
	
	public void evictCache(){
		comentarioDAO.evictCache();
	}
}
