package br.com.plataformalancamento.utility;

import java.text.NumberFormat;
import java.util.Locale;

public class ConfiguracaoMonetariaUtility {
	
	private static NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	
	public static String configurarValorEmReal(Double valorMonetario) {
		return numberFormat.format(valorMonetario);
	}

}
