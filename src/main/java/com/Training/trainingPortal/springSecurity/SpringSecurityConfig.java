package com.Training.trainingPortal.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Training.trainingPortal.serviceImpl.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter 
//securitychainfilter
{
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
	     http.
	     csrf().disable()
	     .authorizeRequests()
					.antMatchers("/api/v1/auth/login",
							"/CourseHome/**" /*getCourse" ,"/CourseHome/createCourse","/CourseHome/deleteRecords/{}" */).permitAll() //to make this url public
	     .anyRequest()
	     .authenticated()
	     .and()
	     .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
	     .and()
	     .sessionManagement()
	     .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	     http.addFilterBefore(this.jwtAuthenticationFilter,  UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{	
	   auth.userDetailsService(this.customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * // Create 2 users for demo
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("user").password("{noop}password").roles("USER") .and()
	 * .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	 * 
	 * }
	 * 
	 * // Secure the endpoins with HTTP Basic authentication
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http //HTTP Basic authentication .httpBasic() .and() .authorizeRequests()
	 * .antMatchers(HttpMethod.GET, "/CourseHome/getCourse").hasRole("USER")
	 * .antMatchers(HttpMethod.POST, "/CourseHome/createCourse/**").hasRole("ADMIN")
	 * .antMatchers(HttpMethod.PUT, "/CourseHome/updaterecords/**").hasRole("ADMIN")
	 * .antMatchers(HttpMethod.DELETE,
	 * "/CourseHome/deleteRecords/**").hasRole("ADMIN") .antMatchers(HttpMethod.GET,
	 * "/CourseHome/getDetails/**").hasRole("ADMIN") .and() .csrf().disable()
	 * .formLogin().disable(); }
	 * 
	 * @Bean public UserDetailsService userDetailsService() { //ok for demo
	 * User.UserBuilder users = User.withDefaultPasswordEncoder();
	 * 
	 * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	 * manager.createUser(users.username("user").password("password").roles("USER").
	 * build());
	 * manager.createUser(users.username("admin").password("password").roles("USER",
	 * "ADMIN").build()); return manager; }
	 */
}
