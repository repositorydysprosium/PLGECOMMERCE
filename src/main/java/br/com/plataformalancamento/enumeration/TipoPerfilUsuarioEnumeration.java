package br.com.plataformalancamento.enumeration;

public enum TipoPerfilUsuarioEnumeration {

	PERFIL_ADMINISTRADOR(1, "Administrador", "ADM"),
	PERFIL_CLIENTE(2, "Cliente", "CLI");
	
	private Integer codigo;
	
	private String descricao;
	
	private String sigla;

	private TipoPerfilUsuarioEnumeration(Integer codigo, String descricao, String sigla) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	public static TipoPerfilUsuarioEnumeration converterEnumeration(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(TipoPerfilUsuarioEnumeration tipoClienteEnumerationResult : TipoPerfilUsuarioEnumeration.values()) {
			if(codigo.equals(tipoClienteEnumerationResult.getCodigo())) {
				return tipoClienteEnumerationResult;
			}
		}
		throw new IllegalArgumentException("O código (" + codigo + ") para enumeração (" + TipoPerfilUsuarioEnumeration.class.getName() + ") não existe!");
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
