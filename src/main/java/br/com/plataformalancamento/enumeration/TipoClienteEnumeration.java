package br.com.plataformalancamento.enumeration;

public enum TipoClienteEnumeration {
	
	PESSOA_FISICA(1, "Pessoa Física", "PF"), 
	PESSOA_JURIDICA(2, "Pessoa Jurídica", "PJ"), 
	PESSOA_AUTORIDADE(3, "Pessoa Autoridade", "PA");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;

	private TipoClienteEnumeration(Integer codigo, String descricao, String sigla) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	public static TipoClienteEnumeration converterEnumeration(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(TipoClienteEnumeration tipoClienteEnumerationResult : TipoClienteEnumeration.values()) {
			if(codigo.equals(tipoClienteEnumerationResult.getCodigo())) {
				return tipoClienteEnumerationResult;
			}
		}
		throw new IllegalArgumentException("O código (" + codigo + ") para enumeração (" + TipoClienteEnumeration.class.getName() + ") não existe!");
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
