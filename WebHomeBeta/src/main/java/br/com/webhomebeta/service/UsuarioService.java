package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.MoradorDAO;
import br.com.webhomebeta.dao.UsuarioDAO;
import br.com.webhomebeta.entity.Morador;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.MoradorTO;
import br.com.webhomebeta.to.UsuarioTO;

@Service("usuarioService")
public class UsuarioService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private UsuarioDAO dao;
	
	public UsuarioTO save(Usuario usuario){

		return dao.save(usuario);
	}
	
	public List<UsuarioTO> getUsuario(){
		
		return dao.getUsuario();
	}
	
}