package br.com.plataformalancamento.exception;

import java.io.Serializable;

public class ErroPadraoException implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer statusHTTPError;
	
	private String mensagemError;
	
	private Long dataHoraError;

	public ErroPadraoException(Integer statusHTTPError, String mensagemError, Long dataHoraError) {
		super();
		this.statusHTTPError = statusHTTPError;
		this.mensagemError = mensagemError;
		this.dataHoraError = dataHoraError;
	}

	public Integer getStatusHTTPError() {
		return statusHTTPError;
	}

	public void setStatusHTTPError(Integer statusHTTPError) {
		this.statusHTTPError = statusHTTPError;
	}

	public String getMensagemError() {
		return mensagemError;
	}

	public void setMensagemError(String mensagemError) {
		this.mensagemError = mensagemError;
	}

	public Long getDataHoraError() {
		return dataHoraError;
	}

	public void setDataHoraError(Long dataHoraError) {
		this.dataHoraError = dataHoraError;
	}
	
}
