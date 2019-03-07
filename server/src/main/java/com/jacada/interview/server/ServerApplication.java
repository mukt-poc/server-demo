package com.jacada.interview.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan(value= {"com.jacada.interview.server.config","com.jacada.interview.server.rest", "com.jacada.interview.server.service"})
public class ServerApplication {

    public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
