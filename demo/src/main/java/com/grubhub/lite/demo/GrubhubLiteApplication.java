package com.grubhub.lite.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GrubhubLiteApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(GrubhubLiteApplication.class, args);
//		for (String output : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(output);
//		}

	}
}
