package com.schoolregistrationsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String REPORT_URL = "/report";
	private static final String COURSES_URL = "/courses/**";
	private static final String STUDENTS_URL = "/students/**";
	private static final String STUDENT_REGISTRY_URL = "/student-registry/**";
	private static final String SWAGGER_URL = "/swagger-ui/**";
	private static final String ACTUATOR_URL = "/actuator";

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(STUDENTS_URL, COURSES_URL, STUDENT_REGISTRY_URL, SWAGGER_URL, ACTUATOR_URL)
				.permitAll().antMatchers(REPORT_URL).access("hasRole('ROLE_ADMIN')")

				.and().csrf()
				.ignoringAntMatchers("/h2-console/**", REPORT_URL, STUDENTS_URL, STUDENTS_URL, STUDENT_REGISTRY_URL,
						SWAGGER_URL, ACTUATOR_URL)

				.and().headers().frameOptions().sameOrigin();
	}

	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());

	}

}
