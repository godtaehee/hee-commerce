package com.hcommerce.heecommerce;

import com.hcommerce.heecommerce.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
@Import(MyBatisConfig.class)
@SpringBootApplication
public class HeeCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeeCommerceApplication.class, args);
	}

}