package br.com.plataformalancamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CIDADE")
public class CidadeModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO")
	private EstadoModel estadoModel;
	
	public CidadeModel() { }
	
	public CidadeModel(Long codigo, String nome, EstadoModel estadoModel) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.estadoModel = estadoModel;
	}

	public CidadeModel(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public CidadeModel(Long codigo) {
		super();
		this.codigo = codigo;
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

	public EstadoModel getEstadoModel() {
		return estadoModel;
	}

	public void setEstadoModel(EstadoModel estadoModel) {
		this.estadoModel = estadoModel;
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
		CidadeModel other = (CidadeModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
