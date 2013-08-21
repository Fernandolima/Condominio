

package br.com.webhomebeta.validacao;

public class ValidatorDescricaoCondominio {
	
	public boolean isValidNomeCondominio(String nome) {
		if (nome.length() < 3
				|| nome.length() > 100 || nome.matches("[0-9]"))
			return false;
		else
			return true;

	}
	
	public boolean isValidAp(String nome) {
		if (nome.length() < 1
				|| nome.length() > 50 || nome.matches("[0-9]"))
			return false;
		else
			return true;

	}
	
	public boolean isValidBloco(String nome) {
		if (nome.length() < 1
				|| nome.length() > 50 || nome.matches("[0-9]"))
			return false;
		else
			return true;

	}

}