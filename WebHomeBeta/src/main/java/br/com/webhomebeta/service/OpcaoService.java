package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.OpcaoDAO;
import br.com.webhomebeta.entity.Opcao;

public class OpcaoService {
	@Autowired
	private OpcaoDAO opcaoDAO;

	public Opcao save(Opcao opcao) {
		return opcaoDAO.save(opcao);
	}

	public Opcao delete(Opcao opcao) {
		return opcaoDAO.delete(opcao);
	}

	public List<Opcao> getLis(int id) {
		return getLis(id);

	}
	
	public void update(int quantidadeVotos, int idOpcao) {
		opcaoDAO.update(quantidadeVotos, idOpcao);
	}

}
