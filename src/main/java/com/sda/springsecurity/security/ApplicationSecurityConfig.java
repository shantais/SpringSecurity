package com.sda.springsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // deklaracja, że rządania mają być autoryzowane
                .anyRequest() // jakie rządania?: kazde
                .authenticated() // musi przejść authentykację (user i password)
                .and()
                .httpBasic(); // uzywamy podstawowej authentykacji
    }
}
