package br.com.plataformalancamento.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.plataformalancamento.model.ClienteModel;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório!") 
	@Length(min = 5, max = 120, message = "O tamanho deve ter entre {min} e {max} caracteres!")
	private String nome;
	
	@Email(message = "O e-mail informado não é valido!")
	private String email;
	
	public ClienteDTO() { }
	
	public ClienteDTO(ClienteModel clienteModel) {
		codigo = clienteModel.getCodigo();
		nome = clienteModel.getNome();
		email = clienteModel.getEmail();
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
	
}
