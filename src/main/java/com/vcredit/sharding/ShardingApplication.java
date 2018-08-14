package com.vcredit.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(value = {"classpath:sharding-databases.xml"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingApplication.class, args);
	}
}
