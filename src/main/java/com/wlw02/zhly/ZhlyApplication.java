package com.wlw02.zhly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wlw02.zhly.dao")
public class ZhlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhlyApplication.class, args);
	}

}

