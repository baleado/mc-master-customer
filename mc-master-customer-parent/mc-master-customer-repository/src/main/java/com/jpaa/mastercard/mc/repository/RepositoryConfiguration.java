package com.jpaa.mastercard.mc.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackageClasses = RepositoryConfiguration.class)
@EnableJpaRepositories(basePackageClasses = RepositoryConfiguration.class)
@EntityScan(basePackageClasses = RepositoryConfiguration.class)
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditAware")
public class RepositoryConfiguration {

	@Bean
	public AuditorAware<String> auditAware() {
		return () -> Optional.of("N/A");
	}
}
