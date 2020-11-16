package br.com.plataformalancamento.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.plataformalancamento.model.PedidoModel;

public abstract class EmailService implements EmailInterfaceService {
	
	@Value("${default.sender}")
	private String remetenteEmail;

	@Override
	public void encaminharEmailConfirmacaoPedido(PedidoModel pedidoModel) {
		SimpleMailMessage simpleMailMessage = prepararSimpleMailMessage(pedidoModel);
		encaminharEmail(simpleMailMessage);
	}
	
	protected SimpleMailMessage prepararSimpleMailMessage(PedidoModel pedidoModel) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(pedidoModel.getClienteModel().getEmail());
			simpleMailMessage.setFrom(remetenteEmail);
			simpleMailMessage.setSubject("Pedido confirmado: Código: " + pedidoModel.getCodigo());
			simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
			simpleMailMessage.setText(pedidoModel.toString());
		return simpleMailMessage;
	}
	
}
