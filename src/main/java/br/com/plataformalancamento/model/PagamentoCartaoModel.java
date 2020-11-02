package br.com.plataformalancamento.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.plataformalancamento.enumeration.TipoEstadoPagamentoEnumeration;

@Entity
@Table(name = "TB_PAGAMENTO_CARTAO")
public class PagamentoCartaoModel extends PagamentoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelaPagamento;
	
	public PagamentoCartaoModel() { }

	public PagamentoCartaoModel(Long codigo, TipoEstadoPagamentoEnumeration estadoPagamentoEnumeration, PedidoModel pedidoModel, Integer numeroParcelaPagamento) {
		super(codigo, estadoPagamentoEnumeration, pedidoModel);
		this.numeroParcelaPagamento = numeroParcelaPagamento;
	}

	public Integer getNumeroParcelaPagamento() {
		return numeroParcelaPagamento;
	}

	public void setNumeroParcelaPagamento(Integer numeroParcelaPagamento) {
		this.numeroParcelaPagamento = numeroParcelaPagamento;
	}

}
