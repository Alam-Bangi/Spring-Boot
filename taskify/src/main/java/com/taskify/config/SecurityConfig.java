//package com.taskify.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            // Authorize access to the H2 console path without authentication
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            // Disable CSRF protection explicitly for the console
//            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
//            // Allow frames from the same origin so the UI renders correctly
//            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
//
//        return http.build();
//    }
//}
