package br.com.plataformalancamento.enumeration;

public enum TipoEstadoPagamentoEnumeration {
	
	PENDENTE(1, "Pendente", "PT"),
	QUITADO(2, "Quitado", "QT"),
	CANCELADO(3, "Cancelado", "CL");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;

	private TipoEstadoPagamentoEnumeration(Integer codigo, String descricao, String sigla) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	public static TipoEstadoPagamentoEnumeration converterEnumeration(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(TipoEstadoPagamentoEnumeration tipoClienteEnumerationResult : TipoEstadoPagamentoEnumeration.values()) {
			if(codigo.equals(tipoClienteEnumerationResult.getCodigo())) {
				return tipoClienteEnumerationResult;
			}
		}
		throw new IllegalArgumentException("O código (" + codigo + ") para enumeração (" + TipoEstadoPagamentoEnumeration.class.getName() + ") não existe!");
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}
	
}
