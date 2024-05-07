//package com.java.saif.DemoProject.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager configureInMemoryUsers() {
//
//        UserDetails userDetails1 = User.builder()
//                .username("user1")
//                .password("{noop}123")
//                .roles("ADMIN").build();
//        UserDetails userDetails2 = User.builder()
//                .username("user2")
//                .password("{noop}1234")
//                .roles("MANAGER").build();
//        UserDetails userDetails3 = User.builder()
//                .username("user3")
//                .password("{noop}12345")
//                .roles("EMPLOYEE").build();
//
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new
//                InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3);
//
//        return inMemoryUserDetailsManager;
//    }
//}
