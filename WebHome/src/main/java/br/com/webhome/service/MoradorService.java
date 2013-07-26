package br.com.webhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhome.dao.MoradorDAO;
import br.com.webhome.entity.Morador;
import br.com.webhome.to.MoradorTO;

@Service("moradorService")
public class MoradorService {
	//@Autowired injeta na propriedade anotada um Bean do Spring que seja od mesmo tipo da propriedade
	@Autowired
	private MoradorDAO dao;
	
	public Morador save(Morador morador){
		dao.save(morador);
		
		return morador;
	}
	//O bean chama o service que chama o dao.
	public MoradorTO getMorador(String login){
		return dao.getMorador(login);
	}
		
	public void update(Morador morador){
		dao.update(morador);
	}
}
