package br.com.plataformalancamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.plataformalancamento.enumeration.TipoClienteEnumeration;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "NOME", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	@Column(name = "CPF_CNPJ", unique = true, nullable = true)
	private String cpf;
	
	@Column(name = "IDENTIFICADOR_TIPO_CLIENTE", unique = true, nullable = true)
	private Integer identificadorTipoClienteEnumeration;
	
	private TipoClienteEnumeration tipoClienteEnumeration;
	
	@OneToMany(mappedBy = "clienteModel")
	private List<EnderecoModel> enderecoModelList = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "TB_TELEFONE")
	@Column(name = "NUMERO_TELEFONE", unique = true, nullable = true)
	private Set<String> telefoneList = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "clienteModel")
	private List<PedidoModel> pedidoModelList = new ArrayList<>();
	
	public ClienteModel() { }

	public ClienteModel(Long codigo, String nome, String email, String cpf, TipoClienteEnumeration identificadorTipoClienteEnumeration) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.identificadorTipoClienteEnumeration = (identificadorTipoClienteEnumeration == null) ? null : identificadorTipoClienteEnumeration.getCodigo();
	}
	
	public ClienteModel(Long codigo, String nome, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdentificadorTipoClienteEnumeration() {
		return identificadorTipoClienteEnumeration;
	}

	public void setIdentificadorTipoClienteEnumeration(Integer identificadorTipoClienteEnumeration) {
		this.identificadorTipoClienteEnumeration = identificadorTipoClienteEnumeration;
	}

	public TipoClienteEnumeration getTipoClienteEnumeration() {
		return tipoClienteEnumeration;
	}

	public void setTipoClienteEnumeration(TipoClienteEnumeration tipoClienteEnumeration) {
		this.tipoClienteEnumeration = tipoClienteEnumeration;
	}

	public List<EnderecoModel> getEnderecoModelList() {
		return enderecoModelList;
	}

	public void setEnderecoModelList(List<EnderecoModel> enderecoModelList) {
		this.enderecoModelList = enderecoModelList;
	}

	public Set<String> getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(Set<String> telefoneList) {
		this.telefoneList = telefoneList;
	}

	public List<PedidoModel> getPedidoModelList() {
		return pedidoModelList;
	}

	public void setPedidoModelList(List<PedidoModel> pedidoModelList) {
		this.pedidoModelList = pedidoModelList;
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
		ClienteModel other = (ClienteModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
