package br.com.webhomebeta.validacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class ValidadorAtas {
	
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
	
	public boolean isValidAtas( String atas) {
		if (atas.length() < 3
				|| atas.length() > 2500)
			return false;
		else
			return true;

	}


}
