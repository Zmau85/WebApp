package com.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication()
		.withUser(users.username("Pera").password("123").roles("EMPLOYEE", "ADMIN"))
		.withUser(users.username("Mika").password("456").roles("EMPLOYEE", "MANAGER"))
		.withUser(users.username("Zika").password("789").roles("EMPLOYEE"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/managers/**").hasRole("MANAGER")
				.antMatchers("/administrators/**").hasRole("ADMIN")
				.and().formLogin().loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateUser").permitAll()
				.and().logout()
				.permitAll().and()
				.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
