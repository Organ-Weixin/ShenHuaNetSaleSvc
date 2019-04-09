package com.boot.security.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
