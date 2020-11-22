package br.com.plataformalancamento.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MockEmailService extends EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void encaminharEmail(SimpleMailMessage simplaMailMessage) {
		LOGGER.info("Simulando encio de E-mail!");
		LOGGER.info(simplaMailMessage.toString());
		LOGGER.info("E-mail encaminhado com sucesso!");
	}

	@Override
	public void encaminharEmailHTML(MimeMessage mimeMessage) {
		LOGGER.info("Simulando envio de e-mail no formato HTML!");
		LOGGER.info(mimeMessage.toString());
		LOGGER.info("E-mail encaminhado com sucesso!");
	}

}
