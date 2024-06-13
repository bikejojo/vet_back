// SecurityServiceConfig.java
package com.example.vet_cristo.config;

import com.example.vet_cristo.repository.RolRepository;
import com.example.vet_cristo.repository.UserRepository;
import com.example.vet_cristo.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityServiceConfig {

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository, RolRepository rolRepository) {
        return new CustomUserDetailsService(userRepository, rolRepository);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
