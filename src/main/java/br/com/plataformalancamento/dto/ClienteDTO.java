package br.com.plataformalancamento.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.plataformalancamento.annotation.ClienteRegraNegocioAnnotation;
import br.com.plataformalancamento.model.ClienteModel;

@ClienteRegraNegocioAnnotation
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório!")
	@Length(min = 5, max = 120, message = "O tamanho deve ter entre {min} e {max} caracteres!")
	private String nome;
	
	@Email(message = "O e-mail informado não é valido!")
	private String email;
	
	@NotEmpty
	private String senha;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório!")
	private String cpfcnpj;
	
	@NotNull(message = "Campo de preenchimento obrigatório!")
	private Integer identificadorTipoClienteEnumeration;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório!")
	private String logradouro;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório!")
	private String numero;
	private String complemento;
	private String bairro;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório!")
	private String cep;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório!")
	private String telefoneCelular;
	private String telefoneFixo;
	private String telefoneFixoComercial;
	
	private Long codigoCidade;
	
	public ClienteDTO() { }
	
	public ClienteDTO(ClienteModel clienteModel) {
		codigo = clienteModel.getCodigo();
		nome = clienteModel.getNome();
		email = clienteModel.getEmail();
	}

	public ClienteDTO(Long codigo,
			@NotEmpty(message = "Campo de preenchimento obrigatório!") @Length(min = 5, max = 120, message = "O tamanho deve ter entre {min} e {max} caracteres!") String nome,
			@Email(message = "O e-mail informado não é valido!") String email, String cpfcnpj,
			Integer identificadorTipoClienteEnumeration, String logradouro, String numero, String complemento,
			String bairro, String cep, String telefoneCelular, String telefoneCelularWatsapp, String telefoneFixo,
			String telefoneFixoComercial, Long codigoCidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpfcnpj = cpfcnpj;
		this.identificadorTipoClienteEnumeration = identificadorTipoClienteEnumeration;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.telefoneCelular = telefoneCelular;
		this.telefoneFixo = telefoneFixo;
		this.telefoneFixoComercial = telefoneFixoComercial;
		this.codigoCidade = codigoCidade;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public Integer getIdentificadorTipoClienteEnumeration() {
		return identificadorTipoClienteEnumeration;
	}

	public void setIdentificadorTipoClienteEnumeration(Integer identificadorTipoClienteEnumeration) {
		this.identificadorTipoClienteEnumeration = identificadorTipoClienteEnumeration;
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

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneFixoComercial() {
		return telefoneFixoComercial;
	}

	public void setTelefoneFixoComercial(String telefoneFixoComercial) {
		this.telefoneFixoComercial = telefoneFixoComercial;
	}

	public Long getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Long codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
	
}
