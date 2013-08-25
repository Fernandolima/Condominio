

package br.com.webhomebeta.validacao;

public class ValidatorDescricaoCondominio {
	
	public boolean isValidNomeCondominio(String nome) {
		if (nome.length() < 1
				|| nome.length() > 50 )
			return false;
		else
			return true;

	}
	
	public boolean isValidAp(String nome) {
		if (nome.length() < 1
				|| nome.length() > 50)
			return false;
		else
			return true;

	}
	
	public boolean isValidBloco(String nome) {
		if (nome.length() < 1
				|| nome.length() > 50)
			return false;
		else
			return true;

	}

}