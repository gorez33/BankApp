package com.example.bankapp.config;

import com.example.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
            @Override
            public void configure(HttpSecurity http) throws Exception {
                http
                        .csrf().disable()
                        .sessionManagement().sessionCreationPolicy(STATELESS)
                        .and()
                        .authorizeRequests(authorizeRequests ->
                                authorizeRequests
                                        .requestMatchers("/swagger-ui/**").permitAll()
                                        .requestMatchers("/client").permitAll()
                                        .requestMatchers("/account").hasAnyAuthority("MANAGER")
                                        .anyRequest().permitAll()
                        )
                        .formLogin(withDefaults())
                        .logout(logout -> logout
                                .permitAll()
                        );
            }
        };
    }
}
