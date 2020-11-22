package br.com.plataformalancamento.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.plataformalancamento.model.PedidoModel;

@Service
public abstract class EmailService implements EmailInterfaceService {
	
	@Value("${default.sender}")
	private String remetenteEmail;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void encaminharEmailConfirmacaoPedido(PedidoModel pedidoModel) {
		SimpleMailMessage simpleMailMessage = prepararSimpleMailMessage(pedidoModel);
		encaminharEmail(simpleMailMessage);
	}
	
	private SimpleMailMessage prepararSimpleMailMessage(PedidoModel pedidoModel) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(pedidoModel.getClienteModel().getEmail());
			simpleMailMessage.setFrom(remetenteEmail);
			simpleMailMessage.setSubject("Pedido confirmado: Código: " + pedidoModel.getCodigo());
			simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
			simpleMailMessage.setText(pedidoModel.toString());
		return simpleMailMessage;
	}
	
	@Override
	public void encaminharEmailConfirmacaoPedidoHTML(PedidoModel pedidoModel) {
		MimeMessage mimeMessage;
		try {
			mimeMessage = prepararMimeMessage(pedidoModel);
			encaminharEmailHTML(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	private MimeMessage prepararMimeMessage(PedidoModel pedidoModel) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(pedidoModel.getClienteModel().getEmail());
			mimeMessageHelper.setFrom(remetenteEmail);
			mimeMessageHelper.setSubject("PLGCOMMERCE - Confirmação de Compra");
			mimeMessageHelper.setSentDate(new Date());
			mimeMessageHelper.setText(processarEmailConfirmacaoPedidoHTML(pedidoModel), true);
		return mimeMessage;
	}
	
	private String processarEmailConfirmacaoPedidoHTML(PedidoModel pedidoModel) {
		Context context = new Context();
			context.setVariable("pedidoModel", pedidoModel);
		return templateEngine.process("email/email-confirmacao-pedido-template.html", context);
	}
	
}
