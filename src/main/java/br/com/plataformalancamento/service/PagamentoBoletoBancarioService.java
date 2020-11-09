package br.com.plataformalancamento.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.plataformalancamento.model.PagamentoBoletoBancarioModel;

@Service
public class PagamentoBoletoBancarioService {
	
	/**
	 * Gerador da Data de Vencimento de um determinadi Boleto Bancário
	 * @param pagamentoBoletoBancarioModel
	 * @param dataPedido
	 */
	public void configurarPagamentoBoletoBancario(PagamentoBoletoBancarioModel pagamentoBoletoBancarioModel, Date dataPedido) {
		Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataPedido);
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			pagamentoBoletoBancarioModel.setDataHoraVencimento(calendar.getTime());
	}

}
