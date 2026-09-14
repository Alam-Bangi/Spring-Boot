package com.learning.features.business_calculator;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApp {
	
	public static void main(String[] args) {

		try (var context = 
				new AnnotationConfigApplicationContext
					(RealWorldSpringContextLauncherApp.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			
		}
	}
}