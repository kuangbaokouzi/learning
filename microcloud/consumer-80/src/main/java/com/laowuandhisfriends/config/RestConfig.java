package com.laowuandhisfriends.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

	@Bean
	public HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		String auth = "lwjava:hello"; // 认证的原始信息
		String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes(Charset.forName("US-ASCII")));
		headers.set("Authorization", encodedAuth);
		return headers;
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
