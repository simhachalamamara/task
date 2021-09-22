package com.js.productsServiceProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication(scanBasePackages = "com.js")
@EnableJpaRepositories(basePackages = "com.js")
@EntityScan(basePackages = "com.js")
@EnableResourceServer
public class ProductsServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceProviderApplication.class, args);
	}


}
