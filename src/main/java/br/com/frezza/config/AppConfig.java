package br.com.frezza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.frezza.model.utils.Calculadora;

@Configuration
public class AppConfig {
	
	@Bean
	public Calculadora getCalculadora () {
		return new Calculadora();
	}
	
}
