package br.com.plataformalancamento.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSMTPService extends EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailSMTPService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Override
	public void encaminharEmail(SimpleMailMessage simpleMailMessage) {
		LOGGER.info("Simulando envio de E-mail!");
		mailSender.send(simpleMailMessage);
		LOGGER.info("E-mail encaminhado com sucesso!");
	}

}
