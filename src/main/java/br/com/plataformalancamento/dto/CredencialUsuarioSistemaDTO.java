package br.com.plataformalancamento.dto;

import java.io.Serializable;

public class CredencialUsuarioSistemaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nomeUsuarioAutenticacao;
	private String senhaUsuarioAltenticacao;
	
	public CredencialUsuarioSistemaDTO() { }

	public String getNomeUsuarioAutenticacao() {
		return nomeUsuarioAutenticacao;
	}

	public String getSenhaUsuarioAltenticacao() {
		return senhaUsuarioAltenticacao;
	}

	public void setNomeUsuarioAutenticacao(String nomeUsuarioAutenticacao) {
		this.nomeUsuarioAutenticacao = nomeUsuarioAutenticacao;
	}

	public void setSenhaUsuarioAltenticacao(String senhaUsuarioAltenticacao) {
		this.senhaUsuarioAltenticacao = senhaUsuarioAltenticacao;
	}

}
