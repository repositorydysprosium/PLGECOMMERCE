package br.com.plataformalancamento.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String mensagemError) {
		super(mensagemError);
	}
	
	public ObjectNotFoundException(String mensagemError, Throwable causeError) {
		super(mensagemError, causeError);
	}
	
}
