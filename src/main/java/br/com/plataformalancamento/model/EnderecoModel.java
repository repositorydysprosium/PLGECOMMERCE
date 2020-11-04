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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;
	
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@Column(name = "COMPLEMENTO", nullable = true)
	private String complemento;
	
	@Column(name = "BAIRRO", nullable = true)
	private String bairro;
	
	@Column(name = "CEP", nullable = false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "ID_CIDADE")
	private CidadeModel cidadeModel;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteModel clienteModel;
	
	public EnderecoModel() { }

	public EnderecoModel(Long codigo, String logradouro, String numero, String complemento, String bairro, String cep, CidadeModel cidadeModel, ClienteModel clienteModel) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidadeModel = cidadeModel;
		this.clienteModel = clienteModel;
	}
	
	public EnderecoModel(String logradouro, String numero, String complemento, String bairro, String cep, CidadeModel cidadeModel, ClienteModel clienteModel) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidadeModel = cidadeModel;
		this.clienteModel = clienteModel;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public CidadeModel getCidadeModel() {
		return cidadeModel;
	}

	public void setCidadeModel(CidadeModel cidadeModel) {
		this.cidadeModel = cidadeModel;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
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
		EnderecoModel other = (EnderecoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
