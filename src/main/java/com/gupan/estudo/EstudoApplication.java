package com.gupan.estudo;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudoApplication {

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/DB_ESTUDO", "postgres", "256545").load();
		flyway.migrate();
		SpringApplication.run(EstudoApplication.class, args);
	}

}
