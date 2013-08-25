package br.com.webhomebeta.validacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

public class Validator {

	private String removeChar(String Cpf) {

		String aux = StringUtils.remove(Cpf, ".");
		String done = StringUtils.remove(aux, "-");

		return done;

	}

	public boolean isCPF(String CpfTemp) {
		String CPF = removeChar(CpfTemp);
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111")
				|| CPF.equals("22222222222") || CPF.equals("33333333333")
				|| CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777")
				|| CPF.equals("88888888888") || CPF.equals("99999999999")
				|| (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;
		System.out.println("oi");
		// "try" - protege o codigo para eventuais erros de conversao de tipo
		// (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere
											// numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos
			// informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public boolean validaData(String data) {
		//Verifica se a data nao esta null
		if (data.equals(null) || data.equals("") || data.equals(" ")) {
			return false;
		} else {
			//Formata a data
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			
			DateTime dateTime = null;
			try {
				dateTime = new DateTime(format.parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//Pega o dia mes e ano
			int dia = dateTime.getDayOfMonth();
			int mes = dateTime.getMonthOfYear();
			int ano = dateTime.getYear();
			
			//logica para verificar se o dia o mes e o ano sao verdadeiros
			if (dia < 1 || mes < 1 || ano < 1)
				return false;
			else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
					|| mes == 10 || mes == 12)
				if (dia <= 31)
					return true;
				else
					return false;
			else if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
				if (dia <= 30)
					return true;
				else
					return false;
			else if (mes == 2)
				if (dateTime.year().isLeap())
					if (dia <= 29)
						return true;
					else
						return false;
				else if (dia <= 28)
					return true;
				else
					return false;
			else if (mes > 12)
				return false;
		}
		return true;
	}

	public boolean isValidEmail(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	public boolean isValidNome(String nome) {
		if (nome.length() < 3
				|| nome.length() > 50 || nome.matches("[0-9]"))
			return false;
		else
			return true;

	}
	
	public boolean isValidApartamento(String apartamento) {
		if (apartamento.length() < 1
				|| apartamento.length() > 30)
			return false;
		else
			return true;

	}
	
	
	
	public boolean isValidSenha(String senha, String confSenha){
		if(senha.length() < 6 || !senha.equals(confSenha)){
			return false;
		}else{
			return true;
		}
	}

}
