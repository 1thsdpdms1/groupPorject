package org.spring.spring_board_0331;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBoard0331Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoard0331Application.class, args);
	}

}
