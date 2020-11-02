package br.com.plataformalancamento.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "DATA_HORA", nullable = false)
	private Date dataHora;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedidoModel")
	private PagamentoModel pagamentoModel;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteModel clienteModel;
	
	@ManyToOne
	@JoinColumn(name = "ID_ENDERECO")
	private EnderecoModel enderecoModel;
	
	public PedidoModel() { }
	
	public PedidoModel(Long codigo, Date dataHora, ClienteModel clienteModel, EnderecoModel enderecoModel) {
		super();
		this.codigo = codigo;
		this.dataHora = dataHora;
		this.clienteModel = clienteModel;
		this.enderecoModel = enderecoModel;
	}

	public PedidoModel(Long codigo, Date dataHora, PagamentoModel pagamentoModel, ClienteModel clienteModel, EnderecoModel enderecoModel) {
		super();
		this.codigo = codigo;
		this.dataHora = dataHora;
		this.pagamentoModel = pagamentoModel;
		this.clienteModel = clienteModel;
		this.enderecoModel = enderecoModel;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public PagamentoModel getPagamentoModel() {
		return pagamentoModel;
	}

	public void setPagamentoModel(PagamentoModel pagamentoModel) {
		this.pagamentoModel = pagamentoModel;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public EnderecoModel getEnderecoModel() {
		return enderecoModel;
	}

	public void setEnderecoModel(EnderecoModel enderecoModel) {
		this.enderecoModel = enderecoModel;
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
		PedidoModel other = (PedidoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
