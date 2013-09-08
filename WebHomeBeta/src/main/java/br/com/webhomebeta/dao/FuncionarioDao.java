package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Funcionario;

public interface FuncionarioDao {
			
	public void  save(Funcionario funcionario);
	public void editar( Funcionario funcionario);
	public void  delete(Funcionario funcionario);
	public Funcionario getFuncinario(int id);
	public List<Funcionario> getListFuncionairo();
}
