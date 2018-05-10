package com.laowuandhisfriends.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Resource
	public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// 设置全局用户名，密码，角色
		auth.inMemoryAuthentication().withUser("lwjava")
				.password("{bcrypt}$2a$04$L4QaaI1/BSkInOZdzNuFKOuYWBktmKTkHmbXjdR0iYq4xYFUCP536").roles("USER").and()
				.withUser("admin").password("{bcrypt}$2a$04$deean.88NS.Ff/c9YHzkVeDAHNx42my76gYTmb9KOxN/MLaAwSiNy")
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 所有访问都必须首先通过认证
		http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
		// 设置无状态session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
}
