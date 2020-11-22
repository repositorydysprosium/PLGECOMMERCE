package br.com.plataformalancamento.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import br.com.plataformalancamento.model.PedidoModel;

public interface EmailInterfaceService {

	public void encaminharEmailConfirmacaoPedido(PedidoModel pedidoModel);
	public void encaminharEmail(SimpleMailMessage simplaMailMessage);
	
	public void encaminharEmailConfirmacaoPedidoHTML(PedidoModel pedidoModel);
	public void encaminharEmailHTML(MimeMessage mimeMessage);
	
}
