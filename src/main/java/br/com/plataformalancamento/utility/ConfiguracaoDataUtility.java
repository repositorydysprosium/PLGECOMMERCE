package br.com.plataformalancamento.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfiguracaoDataUtility {

	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
	
	public static Date recuperarDataFormato(String formatoDataHora) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DD_MM_YYYY_HH_MM);
		try {
			return simpleDateFormat.parse(formatoDataHora);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String recuperarDataFormato(Date data, String formatoDataHora) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatoDataHora);
		return simpleDateFormat.format(data);
	}
	
}
