package ro.kronsoft.farmacie;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import MyGenerator.SQL;

@SpringBootApplication

public class SpringbootPgsqlFarmacieApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootPgsqlFarmacieApplication.class, args);
		new SQL().connect();
		
		
	}

}
