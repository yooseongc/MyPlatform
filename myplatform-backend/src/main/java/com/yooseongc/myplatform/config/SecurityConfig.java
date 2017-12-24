package com.yooseongc.myplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // ignore resource security
        web.ignoring().antMatchers("/css/**", "/js/**", "/");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/h2console/**").permitAll()
                .antMatchers("/**").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

}
