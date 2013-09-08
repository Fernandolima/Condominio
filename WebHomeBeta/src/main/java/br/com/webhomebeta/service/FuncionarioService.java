package br.com.webhomebeta.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.com.webhomebeta.dao.FuncionarioDao;
import br.com.webhomebeta.entity.DescricaoCondominio;
import br.com.webhomebeta.entity.Funcionario;

@Service
public class FuncionarioService {
	// @Autowired injeta na propriedade anotada um Bean do Spring que seja od
	// mesmo tipo da propriedade
	@Autowired
	private FuncionarioDao funcionarioDao;

	public void save(Funcionario funcionario) {
		funcionarioDao.save(funcionario);

	}

	public void editar(Funcionario funcionario) {
		funcionarioDao.editar(funcionario);

	}

	public void deletar(Funcionario funcionario) {
		funcionarioDao.delete(funcionario);
	}

	public Funcionario getFuncionario(int id) {
		return funcionarioDao.getFuncinario(id);
	}

	public java.util.List<Funcionario> getFuncionario() {

		return funcionarioDao.getListFuncionairo();
	}
}
