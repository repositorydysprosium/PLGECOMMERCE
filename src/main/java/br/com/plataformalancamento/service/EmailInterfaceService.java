package br.com.plataformalancamento.service;

import org.springframework.mail.SimpleMailMessage;

import br.com.plataformalancamento.model.PedidoModel;

public interface EmailInterfaceService {

	public void encaminharEmailConfirmacaoPedido(PedidoModel pedidoModel);
	public void encaminharEmail(SimpleMailMessage simplaMailMessage);
	
}
