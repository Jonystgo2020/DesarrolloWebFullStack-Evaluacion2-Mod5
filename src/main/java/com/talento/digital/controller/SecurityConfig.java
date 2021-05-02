package com.talento.digital.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
	   auth.inMemoryAuthentication()
	   .withUser("admin")
	   .password("{noop}123")
	   .roles("ADMIN","USER", "GUESS")
	   .and().withUser("userpre")
	   .password("{noop}123")
	   .roles("USER")
	   .and().withUser("usertur")
	   .password("{noop}123")
	   .roles("GUESS");
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/serviciopremium/**","/servicioturismo/**").hasRole("ADMIN")
		.antMatchers("/serviciopremium/**").hasRole("USER")
		.antMatchers("/servicioturismo/**").hasRole("GUESS")
	.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/autenticacionUsuario")
		.permitAll()
	.and()
		.logout()
		.logoutSuccessUrl("/logout")
		.permitAll()
	.and()
		.exceptionHandling()
		.accessDeniedPage("/accesodenegado");
}
	
}
