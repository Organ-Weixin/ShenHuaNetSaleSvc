package com.boot.security.server;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.boot.security.server.websocket.ChatRoomServer;

/**
 * 启动类
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class SecurityApplication{

	public static void main(String[] args) {
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(SecurityApplication.class, args);
//	    ChatRoomServer.setApplicationContext(applicationContext);
		SpringApplication.run(SecurityApplication.class, args);
	}

}
