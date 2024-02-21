package com.sda.springsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // adnotacja określająca że klasa będzie zawierała konfogurację dla Security
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    // TODO: ogarnąć jak się w security robi WHITELIST w oddzielnej metodzie

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // deklaracja, że rządania mają być autoryzowane
                .antMatchers("/", "/index") // WHITELIST, czyli to co nie wpływa na authentykację
                .permitAll()
                .anyRequest() // jakie rządania?: kazde
                .authenticated() // musi przejść authentykację (user i password)
                .and()
                .httpBasic(); // uzywamy podstawowej authentykacji
        // BasicAuth nie ma wylogowania
    }
}
