package com.linhnguyen.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// để sử dụng được jpaRepository thì ta phải config ở đây: jpaRepository là hàm chung.
@EnableJpaRepositories(basePackages = {"com.linhnguyen.reppository"})
//bật tính năng quản lí transaction của jpa
@EnableTransactionManagement
public class JPAConfig {
	
//	 Khởi tạo EntityManagerFactory 
	@Bean 
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em  = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistence-data");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em ;
	}
//	Khởi tạo TransactionManager: Rollback, commit, class object.. : bật tính năng tự động quản lí transaction trong jpa.
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean 
	public DataSource dataSource() {
		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springmvcbasic");
		dataSource.setUsername("root");
		dataSource.setPassword("0387092630Linh");	
		return dataSource;
	}
	public Properties additionalProperties() {
		Properties props= new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");// lúc đầu nếu tạo mới, có tồn tại thì xóa db cũ và tạo mới sau khi tạo mới xong thì tắt proper để tránh làm mất dữ liệu khi chạy lại
		// props.setProperty("hibernate.hbm2ddl.auto", "none");
		return props;
	}
}
