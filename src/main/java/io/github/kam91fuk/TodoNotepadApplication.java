package io.github.kam91fuk;

import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class TodoNotepadApplication {


	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoNotepadApplication.class, args);


	}
}
