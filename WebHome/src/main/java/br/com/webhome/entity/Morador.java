package br.com.webhome.entity;

import java.sql.Date;

import javax.persistence.Entity;


@Entity

public class Morador extends Usuario {
	
	
	@Override
	public void setDt_nascimento(Date dt_nascimento) {
		// TODO Auto-generated method stub
		super.setDt_nascimento(dt_nascimento);
	}
	
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	
	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}
	
	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		super.setLogin(login);
	}
	
	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}
	
	@Override
	public void setPermissao(String permissao) {
		// TODO Auto-generated method stub
		super.setPermissao(permissao);
	}
	
	@Override
	public void setSenha(String senha) {
		// TODO Auto-generated method stub
		super.setSenha(senha);
	}
	@Override
	public void setStatus(boolean status) {
		// TODO Auto-generated method stub
		super.setStatus(status);
	}


}
