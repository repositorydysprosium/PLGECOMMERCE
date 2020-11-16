package br.com.plataformalancamento.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "production")
public class ProfileProductionConfiguration {
	
	@Bean
	public boolean instantiateDatabase() {
		return true;
	}
	
}
