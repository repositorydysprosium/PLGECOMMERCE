package br.com.plataformalancamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.plataformalancamento.enumeration.TipoEstadoPagamentoEnumeration;

@Entity
@Table(name = "TB_PAGAMENTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PagamentoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	
	@Column(name = "TIPO_ESTADO_PAGAMENTO")
	private Integer tipoEstadoPagamentoEnumeration;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "ID_PEDIDO")
	@MapsId
	private PedidoModel pedidoModel;
	
	public PagamentoModel() { }

	public PagamentoModel(Long codigo, TipoEstadoPagamentoEnumeration estadoPagamentoEnumeration, PedidoModel pedidoModel) {
		super();
		this.codigo = codigo;
		this.tipoEstadoPagamentoEnumeration = estadoPagamentoEnumeration.getCodigo();
		this.pedidoModel = pedidoModel;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoEstadoPagamentoEnumeration getEstadoPagamentoEnumeration() {
		return TipoEstadoPagamentoEnumeration.converterEnumeration(tipoEstadoPagamentoEnumeration);
	}

	public void setTipoEstadoPagamentoEnumeration(TipoEstadoPagamentoEnumeration estadoPagamentoEnumeration) {
		this.tipoEstadoPagamentoEnumeration = estadoPagamentoEnumeration.getCodigo();
	}

	public PedidoModel getPedidoModel() {
		return pedidoModel;
	}

	public void setPedidoModel(PedidoModel pedidoModel) {
		this.pedidoModel = pedidoModel;
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
		PagamentoModel other = (PagamentoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
