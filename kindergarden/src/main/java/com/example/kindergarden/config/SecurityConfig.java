package com.example.kindergarden.config;

import com.example.kindergarden.repository.KinderGardenUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor

public class SecurityConfig {
    private KinderGardenUsersRepository kinderGardenUsersRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> kinderGardenUsersRepository.findByUsername(username)
                .map(user -> User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles("USER")  // You can map real roles from user if needed
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(withDefaults())
                .build();
    }
}

