package br.com.plataformalancamento.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorException extends ErroPadraoException {

	private static final long serialVersionUID = 1L;
	
	private List<FildMessageException> fildMessageExceptionList = new ArrayList<>();
	
	public ValidationErrorException(Integer statusHTTPError, String mensagemError, Long dataHoraError) {
		super(statusHTTPError, mensagemError, dataHoraError);
	}

	public List<FildMessageException> getError() {
		return fildMessageExceptionList;
	}

	public void adicionarError(String nomeCampo, String mensagemError) {
		fildMessageExceptionList.add(new FildMessageException(nomeCampo, mensagemError));
		
	}

}
