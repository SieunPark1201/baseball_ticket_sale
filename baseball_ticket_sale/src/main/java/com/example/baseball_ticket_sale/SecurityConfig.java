package com.example.baseball_ticket_sale;

import com.example.baseball_ticket_sale.service.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain myFilter(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","")//login authenticated에서 제외할 대상 url 지정
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/author/login")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(new LoginSuccessHandler())
                .and()
                .logout()
                .logoutUrl("/doLogout")
                .and().build();
    }
}
