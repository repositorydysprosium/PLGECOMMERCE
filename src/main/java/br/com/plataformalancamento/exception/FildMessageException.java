package br.com.plataformalancamento.exception;

import java.io.Serializable;

public class FildMessageException implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nomeCampo;
	
	private String mensagemError;
	
	public FildMessageException() { }

	public FildMessageException(String nomeCampo, String mensagemError) {
		super();
		this.nomeCampo = nomeCampo;
		this.mensagemError = mensagemError;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public String getMensagemError() {
		return mensagemError;
	}

	public void setMensagemError(String mensagemError) {
		this.mensagemError = mensagemError;
	}
	
}
