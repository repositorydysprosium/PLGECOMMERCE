package br.com.plataformalancamento.exception;

public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String mensagemError) {
		super(mensagemError);
	}
	
	public DataIntegrityViolationException(String mensagemError, Throwable causeError) {
		super(mensagemError, causeError);
	}

}
