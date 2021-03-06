package com.annida.registration.security;

import com.annida.registration.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class ApiSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private ApiSecurityServiceImpl apiSecurityImpl;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated();
//		.and().httpBasic();

        // authentication
        http.addFilter(new AuthenticationFilter(super.authenticationManager(), userService, objectMapper));

        // authorization
        http.addFilter(new AuthorizationFilter(super.authenticationManager()));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(apiSecurityImpl).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/user", "/registration")
                .antMatchers(HttpMethod.PUT, "/registration")
                .antMatchers(HttpMethod.PATCH, "/user/forget-password")
                .antMatchers(HttpMethod.GET, "/monitoring/registration/**", "/school-year", "/religion");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods(HttpMethod.POST.name(),
                        HttpMethod.GET.name(), HttpMethod.PATCH.name(), HttpMethod.DELETE.name(),
                        HttpMethod.PUT.name());
            }
        };
    }
}
