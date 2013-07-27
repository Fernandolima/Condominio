package br.com.webhome.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.webhome.dao.MoradorDAO;
import br.com.webhome.dao.UsuarioDAO;
import br.com.webhome.entity.Morador;
import br.com.webhome.entity.Usuario;
import br.com.webhome.to.MoradorTO;
import br.com.webhome.to.UsuarioTO;

@Service("moradorService")
public class UsuarioService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private UsuarioDAO dao;
	
	public UsuarioTO save(Usuario usuario){
		dao.save(usuario);
		UsuarioTO usuarioTO = new UsuarioTO();
		BeanUtils.copyProperties(usuario, usuarioTO);
		return usuarioTO;
	}
	
	public List<UsuarioTO> getUsuario(){
		
		return dao.getUsuario();
	}
	
}