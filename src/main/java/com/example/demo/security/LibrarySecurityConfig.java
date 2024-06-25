 package com.example.demo.security;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;

 import static org.springframework.security.config.Customizer.withDefaults;

 @Configuration
 @EnableWebSecurity
 public class LibrarySecurityConfig {

    private static final String[] SECURED_URLs = { "/books/**" };

    private static final String[] UN_SECURED_URLs = {
          "/books/all",
          "/books/book/{id}",
          "/users/**",
          "/authenticate/**",
          "/register/**"
    };

     @Bean
      PasswordEncoder libraryPasswordEncoder() {
        return new BCryptPasswordEncoder();
     }

   
     @Bean
      SecurityFilterChain librarySecurityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
             .authorizeHttpRequests(requests -> requests
                 .requestMatchers(UN_SECURED_URLs).permitAll()  // Gli URL non sicuri sono accessibili a tutti
                 .requestMatchers(SECURED_URLs).hasAuthority("ADMIN")  // Gli URL sicuri richiedono il ruolo ADMIN
                 .anyRequest().authenticated())  // Tutte le altre richieste richiedono autenticazione
             .httpBasic(withDefaults()).build();
     }

 }
