package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        http.authorizeRequests()
                .antMatchers("/registration", "/login/*").not().fullyAuthenticated()
                .antMatchers("admin/**", "/admin").hasRole("ADMIN")
                .antMatchers("account/**").hasAnyRole()
                .antMatchers("/", "events/**", "/events", "/static/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/logout/success")
            .permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }
}
