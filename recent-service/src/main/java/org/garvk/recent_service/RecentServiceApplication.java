package org.garvk.recent_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.garvk.recent_service.feign")
public class RecentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecentServiceApplication.class, args);
	}

}
