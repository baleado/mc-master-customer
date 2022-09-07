package com.jpaa.mastercard.mc.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.jpaa.mastercard.mc.repository.RepositoryConfiguration;
import com.jpaa.mastercard.mc.services.ServicesConfiguration;
import com.jpaa.mastercard.mc.web.WebConfiguration;

@SpringBootApplication
@Import({ WebConfiguration.class, ServicesConfiguration.class, RepositoryConfiguration.class })
@EnableAspectJAutoProxy
public class MasterCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterCustomerApplication.class, args);
	}
}
