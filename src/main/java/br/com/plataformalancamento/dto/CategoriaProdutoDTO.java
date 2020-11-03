package br.com.plataformalancamento.dto;

import java.io.Serializable;

import br.com.plataformalancamento.model.CategoriaProdutoModel;

public class CategoriaProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String nome;
	
	public CategoriaProdutoDTO() { }
	
	public CategoriaProdutoDTO(CategoriaProdutoModel categoriaProdutoModel) {
		codigo = categoriaProdutoModel.getCodigo();
		nome = categoriaProdutoModel.getNome();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
