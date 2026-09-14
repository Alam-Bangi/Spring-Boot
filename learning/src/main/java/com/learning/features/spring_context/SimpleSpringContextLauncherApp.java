package com.learning.features.spring_context;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApp {

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (SimpleSpringContextLauncherApp.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }
    }
}