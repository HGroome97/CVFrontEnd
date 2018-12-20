package com.qa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.qa.util.Constants;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;

    public SpringSecurityConfig() {
        super();
    }
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
     .usersByUsernameQuery("select username,password, enabled from users where username=?")
     .authoritiesByUsernameQuery("select username, role from users where username=?");
    } 


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
        	.antMatchers(Constants.TRAININGMANAGER_ACCESS_URL).access(Constants.TRAINING_MANAGER_HAS_ROLE)
        	.antMatchers(Constants.TRAINER_ACCESS_URL).access(Constants.TRAINEE_HAS_ROLE)
        	.antMatchers(Constants.TRAINEE_ACCESS_URL).access(Constants.TRAINEE_HAS_ROLE)
        	.antMatchers(Constants.REGISTER_URL).anonymous()
        	.anyRequest().authenticated()
        .and()
        	.formLogin()
        	.loginPage(Constants.LOGIN_URL).permitAll()
        	.loginProcessingUrl(Constants.PERFORM_LOGIN)
        	.defaultSuccessUrl(Constants.HOMEPAGE_URL,true)
        	.failureUrl(Constants.LOGIN_ERROR_URL)
        .and()
        	.logout()
        	.logoutUrl(Constants.PERFORM_LOGOUT)
        	.deleteCookies("JSESSIONID")
        .and()
    		.exceptionHandling()
    		.accessDeniedPage(Constants.ACCESS_DENIED_URL);
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
	}
}