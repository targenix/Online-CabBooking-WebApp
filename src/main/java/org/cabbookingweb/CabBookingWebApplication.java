package org.cabbookingweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CabBookingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingWebApplication.class, args);
	}

}
