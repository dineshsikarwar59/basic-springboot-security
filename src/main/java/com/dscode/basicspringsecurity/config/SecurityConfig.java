package com.dscode.basicspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(customizer -> customizer.disable());
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/user/register").permitAll());
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/user/update").hasAnyAuthority("ADMIN"));
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/user/all").hasAnyAuthority("USER","ADMIN"));
		http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}

	/*
	 * @Bean public UserDetailsService userDetails() { UserDetails user1 =
	 * User.withUsername("ankit").password("{noop}123a").roles("ADMIN").build();
	 * UserDetails user2 =
	 * User.withUsername("deepak").password("{noop}123d").roles("user").build();
	 * return new InMemoryUserDetailsManager(user1, user2); }
	 */

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

}
