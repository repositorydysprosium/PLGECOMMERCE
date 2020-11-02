package br.com.plataformalancamento.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.plataformalancamento.enumeration.TipoEstadoPagamentoEnumeration;
import br.com.plataformalancamento.utility.DateUtility;

@Entity
@Table(name = "TB_PAGAMENTO_BOLETO_BANCARIO")
public class PagamentoBoletoBancarioModel extends PagamentoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = DateUtility.DD_MM_YYYY)
	private Date dataHoraVencimento;
	
	@JsonFormat(pattern = DateUtility.DD_MM_YYYY)
	private Date dataHoraPagamento;
	
	public PagamentoBoletoBancarioModel() { }

	public PagamentoBoletoBancarioModel(Long codigo, TipoEstadoPagamentoEnumeration estadoPagamentoEnumeration, PedidoModel pedidoModel, Date dataHoraVencimento, Date dataHoraPagamento) {
		super(codigo, estadoPagamentoEnumeration, pedidoModel);
		this.dataHoraVencimento = dataHoraVencimento;
		this.dataHoraPagamento = dataHoraPagamento;
	}

	public Date getDataHoraVencimento() {
		return dataHoraVencimento;
	}

	public void setDataHoraVencimento(Date dataHoraVencimento) {
		this.dataHoraVencimento = dataHoraVencimento;
	}

	public Date getDataHoraPagamento() {
		return dataHoraPagamento;
	}

	public void setDataHoraPagamento(Date dataHoraPagamento) {
		this.dataHoraPagamento = dataHoraPagamento;
	}

}
