package br.com.plataformalancamento.utility;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class ConfiguracaoURLUtility {
	
	public static List<Long> decodeStringLongList(String codigoCategoriaProdutoList) {
		String[] vetorString = codigoCategoriaProdutoList.split(",");
		List<Long> integerList = new ArrayList<>();
		for( int index = 0 ; index < vetorString.length ; index++ ) {
			integerList.add(Long.parseLong(vetorString[index]));
		}
		return integerList;
//		return Arrays.asList(codigoCategoriaProdutoList.split(",")).stream().map( integer -> Long.parseInt(integer)).collect(Collectors.toList());
	}
	
	public static String decodeParamentroURL(String parametro) {
		try {
			return URLDecoder.decode(parametro, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
