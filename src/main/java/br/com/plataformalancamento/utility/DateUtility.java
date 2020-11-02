package br.com.plataformalancamento.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm";
	
	public static Date recuperarDataFormato(String formatoDataHora) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtility.DD_MM_YYYY_HH_MM_SS);
		try {
			return simpleDateFormat.parse(formatoDataHora);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
