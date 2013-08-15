//package br.com.webhomebeta.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.webhomebeta.dao.MoradorDAO;
//import br.com.webhomebeta.entity.Morador;
//
//
//@Service("moradorService")
//public class MoradorService {
//	//@Autowired injeta na propriedade anotada um Bean do Spring que seja od mesmo tipo da propriedade
//	@Autowired
//	private MoradorDAO dao;
//	
//	public Morador save(Morador morador){
//		return dao.save(morador);
//	}
//	//O bean chama o service que chama o dao.
//	public Morador getMorador(String login){
//		return dao.getMorador(login);
//	}
//		
//	public void update(Morador morador){
//		dao.update(morador);
//	}
//}
