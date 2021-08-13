package com.entrytest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.entrytest.service.imp.UserDetailsServerImpl;

import net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy.Disabled;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySequrityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServerImpl userDetailsServerImpl;
	@Autowired
	private JwtAutonationEntryPoint jwtAutonationEntryPoint;
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return  new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
	//super.configure(auth);
		auth.userDetailsService(this.userDetailsServerImpl).passwordEncoder(passwordEncoder());
		
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http	
				.csrf()
		       	.disable()
		       	.cors()
		       	.disable()
		       	.authorizeRequests()
		       	.antMatchers("/generat-token","/user/").permitAll()
		       	.antMatchers(HttpMethod.OPTIONS).permitAll()
				.anyRequest().authenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(jwtAutonationEntryPoint)
				.and()
		       	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				http.addFilter(jwtAuthantionFiltet,UsernamePasswordAuthenticationFilter.class);
		       	
		       	
				
	}
	
	
	
	
	
	
	// WebSecurityConfigurerAdapter extends this class
	//because of all secutiry configuation is done
	// we want make  own configaution so this we are overriding
	
	
}
