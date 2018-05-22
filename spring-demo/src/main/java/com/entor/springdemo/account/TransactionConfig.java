package com.entor.springdemo.account;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.entor.springdemo.account")
// 导入jdbc属性列表
@ImportResource(locations = "classpath:jdbc.xml")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class TransactionConfig {

	// 从属性列表中将属性一一提取
	@Value("${jdbc.driverClass}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.user}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.maxTotal}")
	private String maxTotal;
	@Value("${jdbc.maxIdle}")
	private String maxIdle;
	@Value("${jdbc.minIdle}")
	private String minIdle;
	@Value("${jdbc.initialSize}")
	private String initialSize;

	// 创建数据源
	// 相当于<bean id="dataSource"
	// class="org.apache.commons.dbcp2.BasicDataSource">
	@Bean
	public DataSource dataSources() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setMaxTotal(Integer.parseInt(maxTotal));
		ds.setMaxIdle(Integer.parseInt(maxIdle));
		ds.setMinIdle(Integer.parseInt(minIdle));
		ds.setInitialSize(Integer.parseInt(initialSize));
		return ds;
	}

	// 创建JDBC模版
	// 相当于<bean id="jdbcTemplate"
	// class="org.springframework.jdbc.core.JdbcTemplate">
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	// 创建事务管理器
	// 相当于<bean id="txManager"
	// class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
