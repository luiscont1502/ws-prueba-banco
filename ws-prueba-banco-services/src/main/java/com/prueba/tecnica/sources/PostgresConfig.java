package com.prueba.tecnica.sources;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.prueba.persistence.postgres.repository")
@EntityScan(basePackages = "com.prueba.persistence.postgres.entity")
public class PostgresConfig {

    /**
     * Configura el DataSource, es decir, la conexión
     * hacia la base de datos PostgreSQL.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        dataSource.setUrl("jdbc:postgresql://localhost:5432/prueba_banco");
        dataSource.setUsername("postgres");
        dataSource.setPassword("");
        return dataSource;
    }

     /**
     * Configura el EntityManagerFactory.
     *
     * Es el componente encargado de:
     * - gestionar las entidades JPA
     * - interactuar con Hibernate
     * - mapear objetos Java a tablas de base de datos
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.prueba.persistence.postgres.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "none");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        emf.setJpaProperties(props);
        return emf;
    }

    /**
     * Configura el TransactionManager.
     *
     * Se encarga de gestionar las transacciones de la aplicación,
     * asegurando consistencia en operaciones como:
     * - inserciones
     * - actualizaciones
     * - eliminaciones
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
