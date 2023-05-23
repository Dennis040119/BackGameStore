package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "src.com.example.demo.*" })
@ComponentScan({"controllers","entity","repository","service"})
public class StoreApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

}
