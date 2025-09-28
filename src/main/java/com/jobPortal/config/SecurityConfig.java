package com.jobPortal.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Security filter chain (replaces WebSecurityConfigurerAdapter)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF since we're using JWT for a REST API
                .authorizeRequests(auth -> auth
                                .antMatchers("/api/auth/**").permitAll()
                                .antMatchers("/admin/**").hasRole("ADMIN")
                                .antMatchers("/recruiter/**").hasRole("RECRUITER")
                                .antMatchers("/student/**").hasRole("STUDENT")
                                .anyRequest().authenticated()
                );
            /* .formLogin(form -> form
                .loginPage("/login")                       // THIS IS MAINLY FOR FRONTEND LOGIN PAGE 
                .permitAll()
            )
            .logout(logout -> logout.permitAll()); */
            

        return http.build();
    }

    // Authentication manager bean (needed for login)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
