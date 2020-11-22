package br.com.plataformalancamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.plataformalancamento.enumeration.TipoClienteEnumeration;
import br.com.plataformalancamento.enumeration.TipoPerfilUsuarioEnumeration;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	// TODO -- Alterar "unique" para "true" apos os testes
	@Column(name = "NOME", unique = false, nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(name = "SENHA", unique = true, nullable = true)
	private String senha;
	
	// TODO -- Alterar "unique" para "true" apos os testes
	@Column(name = "CPF_CNPJ", unique = false, nullable = true)
	private String cpf;
	
	@Column(name = "ID_TIPO_PESSOA", nullable = true)
	private Integer identificadorTipoClienteEnumeration;
	
	@Transient
	private TipoClienteEnumeration tipoClienteEnumeration;
	
	@OneToMany(mappedBy = "clienteModel", cascade = CascadeType.ALL)
	private List<EnderecoModel> enderecoModelList = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "TB_TELEFONE")
	@Column(name = "NUMERO_TELEFONE", nullable = true)
	private Set<String> telefoneList = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "clienteModel")
	private List<PedidoModel> pedidoModelList = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TB_PERFIL_USUARIO")
	private Set<Integer> perfilUsuarioEnumerationList = new HashSet<>();
	
	public ClienteModel() { }

	public ClienteModel(Long codigo, String nome, String email, String cpf, TipoClienteEnumeration identificadorTipoClienteEnumeration) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.identificadorTipoClienteEnumeration = (identificadorTipoClienteEnumeration == null) ? null : identificadorTipoClienteEnumeration.getCodigo();
	}
	
	public ClienteModel(Long codigo, String nome, String email, String cpf, TipoClienteEnumeration identificadorTipoClienteEnumeration, String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.identificadorTipoClienteEnumeration = (identificadorTipoClienteEnumeration == null) ? null : identificadorTipoClienteEnumeration.getCodigo();
		this.senha = senha;
	}
	
	public ClienteModel(Long codigo, String nome, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}
	
	public Set<TipoPerfilUsuarioEnumeration> getPerfilUsuarioEnumeration() {
		return perfilUsuarioEnumerationList.stream().map( perfilRetorno -> TipoPerfilUsuarioEnumeration.converterEnumeration(perfilRetorno)).collect(Collectors.toSet());
	}
	
	public void adicionarPerfilUsuarioEnumeration(TipoPerfilUsuarioEnumeration tipoPerfilUsuarioEnumeration) {
		perfilUsuarioEnumerationList.add(tipoPerfilUsuarioEnumeration.getCodigo());
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	
	public Set<Integer> getPerfilUsuarioEnumerationList() {
		return perfilUsuarioEnumerationList;
	}

	public void setPerfilUsuarioEnumerationList(Set<Integer> perfilUsuarioEnumerationList) {
		this.perfilUsuarioEnumerationList = perfilUsuarioEnumerationList;
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
