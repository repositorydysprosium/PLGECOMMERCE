package br.com.plataformalancamento.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.plataformalancamento.service.DatabaseService;

@Configuration
@Profile(value = "test")
public class ProfileTestConfiguration {
	
	@Autowired
	private DatabaseService databaseService;

	@Bean
	public boolean instantiateDatabase() {
		databaseService.instantiateTestDatabase();
		return true;
	}
	
}
