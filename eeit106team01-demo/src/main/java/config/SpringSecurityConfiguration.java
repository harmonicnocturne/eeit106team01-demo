package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(null);
//		auth.inMemoryAuthentication()
//		.withUser("albert").password(passwordEncoder().encode("albert")).roles("guest")
//		.and()
//		.withUser("naomi").password(passwordEncoder().encode("naomi")).roles("guest");
//		;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/secure").hasAnyRole("guest")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		.failureForwardUrl("/login")
		.and()
		.logout()
		.deleteCookies("SESSIONID")
		.and()
		.csrf()
		.disable()
		;
	}
}
