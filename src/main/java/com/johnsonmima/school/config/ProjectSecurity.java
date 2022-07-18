package com.johnsonmima.school.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurity {
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    //     http.authorizeRequests((authz) -> 
    //     authz.anyRequest().permitAll()
    //     ).formLogin().and().httpBasic();

    // return http.build();
    // }


    // permitAll
    //authenticated - requires authentication

    // CSRF 


    // mvcMatchers - mvcMatchers(HttpMethod.GET, "/home") or mvcMatchers("/home")
    //antMatchers - 

     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       // calling http.csrf().disable() will disable CSRF
        http 
        .authorizeRequests()
        .mvcMatchers("/dashboard").authenticated()
        .mvcMatchers("/home").permitAll()
        .mvcMatchers("/holdays/**").permitAll()
        .mvcMatchers("/login").permitAll()
        .and()
        .formLogin()
         .loginPage("/login")
         .successForwardUrl("/dashboard")
         .failureForwardUrl("/login?error=true").permitAll()
        .and()
        .logout().
        logoutSuccessUrl("/login?logout=true").
        invalidateHttpSession(true).permitAll()

        .and().httpBasic();

    return http.build();
    }


    // @Bean 
    // public WebSecurityCustomizer webSecurityCustomizer() {
    //     return (web) -> web.ignoring().antMatchers("/");
    // }


    // IN MEMORY only for testing

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user1")
            .password("password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}



