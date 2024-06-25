//package com.example.demo.security;
//
//import org.springframework.context.annotation.Bean;
//// import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//// import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//
//// import static org.springframework.security.config.Customizer.withDefaults;
//
//// import static org.springframework.security.config.Customizer.withDefaults;
//
//// import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class UserRegistrationSecurityConfig {
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//      return new BCryptPasswordEncoder();
//   }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.cors()
//                .and().csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/register/**")
//                .permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/users/**") 
//                .hasAnyAuthority("USER", "ADMIN")
//                .and().formLogin().and().build();
//    }
//}
