package br.com.plataformalancamento.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.plataformalancamento.service.DatabaseService;

@Configuration
@Profile(value = "production")
public class ProfileProductionConfiguration {
	
	@Autowired
	private DatabaseService databaseService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategyDatabase;

	@Bean
	public boolean instantiateDatabase() {
		if(!strategyDatabase.equals("create")) {
			return false;
		}
		databaseService.instantiateTestDatabase();
		return true;
	}
	
}
