package br.com.plataformalancamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "PRECO", length = 10, precision = 2, nullable = false)
	private Double preco;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "TB_PRODUTO_CATEGORIA", 
			   joinColumns = @JoinColumn(name = "ID_PRODUTO"), 
			   inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIA"))
	private List<CategoriaProdutoModel> categoriaProdutoModelList = new ArrayList<>();
	
	public ProdutoModel() { }

	public ProdutoModel(Long codigo, String nome, Double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<CategoriaProdutoModel> getCategoriaProdutoModelList() {
		return categoriaProdutoModelList;
	}

	public void setCategoriaProdutoModelList(List<CategoriaProdutoModel> categoriaProdutoModelList) {
		this.categoriaProdutoModelList = categoriaProdutoModelList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoModel other = (ProdutoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
