package com.hry.component.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;


@SpringBootApplication
@MapperScan("com.hry.component.mybatisplus.mapper")
@EnableTransactionManagement
public class MybatisPlusApplication {

	public static void main(String[] args) {
		String profiles = System.getProperty("spring.profiles.active");

		if (StringUtils.isEmpty(profiles) && (args == null || args.length == 0)) {
			args = new String[1];
			args[0] = "--spring.profiles.active=dev";
		}
		SpringApplication.run(MybatisPlusApplication.class, args);
	}

}
