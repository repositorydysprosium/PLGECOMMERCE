package br.com.plataformalancamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_ESTADO")
public class EstadoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "NOME", length = 50, unique = true, nullable = false)
	private String nome;
	
	@Column(name = "SIGLA", length = 2, unique = true, nullable = true)
	private String sigla;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estadoModel")
	private List<CidadeModel> cidadeModelList = new ArrayList<>();
	
	public EstadoModel() {}
	
	public EstadoModel(Long codigo, String nome, String sigla) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
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
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<CidadeModel> getCidadeModelList() {
		return cidadeModelList;
	}

	public void setCidadeModelList(List<CidadeModel> cidadeModelList) {
		this.cidadeModelList = cidadeModelList;
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
		EstadoModel other = (EstadoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
