package br.com.plataformalancamento.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSMTPService extends EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailSMTPService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void encaminharEmail(SimpleMailMessage simpleMailMessage) {
		LOGGER.info("Simulando envio de E-mail!");
		mailSender.send(simpleMailMessage);
		LOGGER.info("E-mail encaminhado com sucesso!");
	}

	@Override
	public void encaminharEmailHTML(MimeMessage mimeMessage) {
		LOGGER.info("Simulando envio de e-mail no formato HTML!");
		javaMailSender.send(mimeMessage);
		LOGGER.info("E-mail encaminhado com sucesso!");
	}

}
