package com.clean_architecture_java.cleanarchitecturejava.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/**").permitAll()

                //.requestMatchers("/swagger-resources/**", "/swagger-ui/**", "/v3/api-docs/**", "/webjars/**").permitAll() // Permitir acceso sin autenticación a Swagger
                //.requestMatchers("/api/users/**").permitAll()
                //.anyRequest().authenticated() // Requerir autenticación para cualquier otra ruta
            ).csrf(csrf -> csrf.disable());
            /* .formLogin(form -> form
                .permitAll() // Permitir acceso a la página de inicio de sesión
            )
            .logout(logout -> logout
                .permitAll() // Permitir acceso a la página de cierre de sesión
            );*/

        return http.build();
    }
  
}
