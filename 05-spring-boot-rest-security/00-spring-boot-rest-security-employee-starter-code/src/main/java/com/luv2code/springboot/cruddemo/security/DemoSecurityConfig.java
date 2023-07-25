package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //Add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        //Tells Spring Security to use JDBC  authentication with our data source
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")

        );
        //Use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery (CSRF)
        //Not required for stateless REST APIs that use POST, PUT, DELETE, PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


      /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails jhon = User.builder()
                .username("jhon")
                .password("{noop}jhon123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}mary123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}susan123")
                .roles("EMPLOYEE","MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(jhon,mary,susan);
    }
*/

}
