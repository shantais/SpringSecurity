package com.sda.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity // adnotacja określająca że klasa będzie zawierała konfogurację dla Security
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // TODO: ogarnąć jak się w security robi WHITELIST w oddzielnej metodzie
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // deklaracja, że rządania mają być autoryzowane
                .antMatchers( "/") // WHITELIST, czyli to co nie wpływa na authentykację
                .permitAll()
                .anyRequest() // jakie rządania?: kazde
                .authenticated() // musi przejść authentykację (user i password)
                .and()
                .httpBasic(); // uzywamy podstawowej authentykacji
        // BasicAuth nie ma wylogowania
    }

    @Override
    @Bean // zwraca bean'a i będzie zarządzana przez kontekst Springa
    protected UserDetailsService userDetailsService() {
        UserDetails jarekUser = User.builder()
                .username("jarek")
                .password(passwordEncoder.encode("123456"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(jarekUser);
    }
}
