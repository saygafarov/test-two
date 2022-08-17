package com.example.test_two.configuration;

//import com.example.test_two.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    UserService userService;
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());

        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("igor").password("igor").roles("USER"))
                .withUser(userBuilder.username("u").password("u").roles("USER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf()
//                    .disable()
//                .authorizeRequests()
//                    .antMatchers("/registration").not().fullyAuthenticated()
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .antMatchers("/api/animals/**").hasRole("USER")
//                    .antMatchers("/", "/resources/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/")
//                    .permitAll()
//                .and()
//                    .logout()
//                    .permitAll()
//                    .logoutSuccessUrl("/");



                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/animals/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/animals").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/animals/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/animals/**").hasRole("USER")
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable();
    }
}
