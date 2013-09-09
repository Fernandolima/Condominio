package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.PublicacaoDAO;
import br.com.webhomebeta.entity.Publicacao;

@Service
public class PublicacaoService {
	@Autowired
	private PublicacaoDAO publicacaoDAO;
	
	public void salvar(Publicacao publicacao){
		publicacaoDAO.salvarPublicacao(publicacao);
	}
	
	public List<Publicacao> getPublicacoes(){
		return publicacaoDAO.getPublicacoes();
	}
	
	public List<Publicacao> getPublicacao(int idUser){
		return publicacaoDAO.getPublicacao(idUser);
	}
}
