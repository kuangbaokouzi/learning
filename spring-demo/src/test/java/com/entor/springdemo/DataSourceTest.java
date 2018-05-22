package com.entor.springdemo;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@ContextConfiguration(locations = { "classpath:spring-jdbc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {

	@Resource
	private DriverManagerDataSource datasource;

	@Resource
	private BasicDataSource datasource2;

	@Resource
	private ComboPooledDataSource datasource3;

	@Test
	public void testSpringJBDCDatasource() throws SQLException {
		System.out.println(datasource.getUrl());
	}

	@Test
	public void testDBCPDatasource() throws SQLException {
		System.out.println(datasource2.getUrl());
	}

	@Test
	public void testC3P0Datasource() throws SQLException {
		System.out.println(datasource3.getJdbcUrl());
	}
}
