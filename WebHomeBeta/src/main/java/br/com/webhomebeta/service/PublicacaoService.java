package br.com.webhomebeta.service;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.PublicacaoDAO;
import br.com.webhomebeta.entity.Publicacao;

@Service
public class PublicacaoService {
	@Autowired
	private PublicacaoDAO publicacaoDAO;
		
	public Publicacao salvar(Publicacao publicacao){
		return publicacaoDAO.salvarPublicacao(publicacao);
	}
	
	public List<Publicacao> getPublicacoes(int colunaInicial, int tamanhoColuna){
		return publicacaoDAO.getPublicacoes(colunaInicial,tamanhoColuna);
	}
	
	public List<Publicacao> getPublicacao(int idUser){
		return publicacaoDAO.getPublicacao(idUser);
	}
	
	public void deletarPublicacao(int idUsuario, int idPublicacao){
		publicacaoDAO.deletarPublicacao(idUsuario, idPublicacao);
	}
	
	public void update(int id, String imagem){
		publicacaoDAO.update(id, imagem);
	}
	
	public Publicacao getUnicaPublicacao(int idPublicacao){
		return publicacaoDAO.getUnicaPublicacao(idPublicacao);
	}
}
