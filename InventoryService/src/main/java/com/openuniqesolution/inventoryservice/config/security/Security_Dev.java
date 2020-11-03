package com.openuniqesolution.inventoryservice.config.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Profile("dev")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Security_Dev extends WebSecurityConfigurerAdapter{

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails supplier = User
							.withDefaultPasswordEncoder()
							.username("supplier")
							.password("supplier")
							.roles("SUPPLIER")
							.build();
		UserDetails admin = User
							.withDefaultPasswordEncoder()
							.username("admin")
							.password("admin")
							.roles("ADMIN")
							.build();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(admin);
		manager.createUser(supplier);
		return manager;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.
			authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
}
