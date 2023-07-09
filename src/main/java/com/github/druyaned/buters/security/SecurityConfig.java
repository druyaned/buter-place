package com.github.druyaned.buters.security;

import com.github.druyaned.buters.ButerUser;
import com.github.druyaned.buters.data.UserRepository;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService(UserRepository repo) {
        return username -> {
            ButerUser user = repo.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("'" + username + "' не найден");
            }
            return user;
        };
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/design", "/orders/**").hasRole("USER")
                        .anyRequest().permitAll())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login").defaultSuccessUrl("/home", true))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/home"))
                .headers(headersCustomizer -> headersCustomizer
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()))
                .csrf(csrfCustomizer -> csrfCustomizer
                        .ignoringRequestMatchers(PathRequest.toH2Console()))
                .build();
    }
    
}
