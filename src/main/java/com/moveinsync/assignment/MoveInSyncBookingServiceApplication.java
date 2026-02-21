package com.moveinsync.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MoveInSyncBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoveInSyncBookingServiceApplication.class, args);
		System.out.println(new BCryptPasswordEncoder());
	    System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}

}
