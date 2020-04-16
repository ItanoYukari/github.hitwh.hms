package com.hlh;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.hlh.mapper") //@MapperScan 用户扫描MyBatis的Mapper接口
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	 
}
