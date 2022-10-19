package com.examen;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "factuEntityManagerFactory", transactionManagerRef = "factuTransactionManager", basePackages = {
		"com.examen.repository" })
public class TiendaEmyconBDConfig {
	@Primary
	@Bean(name = "factuDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "factuEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean factuEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("factuDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.examen.domain").persistenceUnit("factu")
				.build();
	}

	@Primary
	@Bean(name = "factuTransactionManager")
	public PlatformTransactionManager factuTransactionManager(
			@Qualifier("factuEntityManagerFactory") EntityManagerFactory factuEntityManagerFactory) {
		return new JpaTransactionManager(factuEntityManagerFactory);
	}
}

