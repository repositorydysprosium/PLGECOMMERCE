package br.com.plataformalancamento.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;


public class MockEmailService extends EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void encaminharEmail(SimpleMailMessage simplaMailMessage) {
		LOGGER.info("Simulando encio de E-mail!");
		LOGGER.info(simplaMailMessage.toString());
		LOGGER.info("E-mail encaminhado com sucesso!");
	}

}
