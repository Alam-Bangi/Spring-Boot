package com.learning.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learning.game")
public class GamingAppLauncher {
	
	public static void main(String[] args) {

		try (var context = 
				new AnnotationConfigApplicationContext
					(GamingAppLauncher.class)) {

			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();

		}
	}
}