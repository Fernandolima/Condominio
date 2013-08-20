package br.com.webhomebeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.ComentarioDAO;
import br.com.webhomebeta.entity.Comentario;

@Service("comentarioService")
public class ComentarioService {
	@Autowired
	private ComentarioDAO comentarioDAO;

	public void save(Comentario comentario) {
		comentarioDAO.salvarComentario(comentario);
	}
}
