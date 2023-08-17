package com.raphaelferreira.detectoreventapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DetectorEventApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DetectorEventApiApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(DetectorEventApiApplication.class, args);
		DetectorEventApiApplication myApp = context.getBean(DetectorEventApiApplication.class);
	}

}
