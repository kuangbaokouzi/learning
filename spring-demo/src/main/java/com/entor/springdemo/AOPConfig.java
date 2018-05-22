package com.entor.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.entor.springdemo")
@EnableAspectJAutoProxy
public class AOPConfig {

}
