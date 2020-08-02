package com.dbs.ordermanagesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderManageSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManageSystemApplication.class, args);
	}

}
