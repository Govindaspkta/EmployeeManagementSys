//package com.employeemgmntapp.SecurityConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//	httpSecurity.
//	authorizeHttpRequests((requests)->requests
//			.requestMatchers(HttpMethod.POST,"/employessys").permitAll()
//			.anyRequest().authenticated());
//	
//	return httpSecurity.build();
//
//}
//}
