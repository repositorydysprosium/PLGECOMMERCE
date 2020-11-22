package br.com.plataformalancamento.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment environment;
	
	private static final String[] URL_PRIVADAS = {
		"/h2-console/**"
	};
	
	private static final String[] URL_PUBLICAS = {
			"/categoriaproduto/**",
			"/pedido/**"
		};
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		if(Arrays.asList(environment.getActiveProfiles()).contains("test")) {
			httpSecurity.headers().frameOptions().disable();
		}
		httpSecurity.cors().and().csrf().disable();
		httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET, URL_PUBLICAS).permitAll();
		httpSecurity.authorizeRequests().antMatchers(URL_PRIVADAS).permitAll().anyRequest().authenticated();
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
			urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return urlBasedCorsConfigurationSource;
	}
	
}
