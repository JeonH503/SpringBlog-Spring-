package com.spp.springblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable()
				.and()
			.authorizeRequests()
				.antMatchers("/","/post","/user/login","/user/singUp","/user/singUpConfirm").permitAll()
				.antMatchers("/write","/postDel","/postMod").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				.logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true) 
				.and()
			.formLogin()
				.loginPage("/user/login")
				.loginProcessingUrl("/loginProcess")
				.defaultSuccessUrl("/")
				.usernameParameter("vusername")
				.passwordParameter("vpassword")
				.permitAll();
				
			
	}
	@Bean public PasswordEncoder passwordEncoder() { 
		return PasswordEncoderFactories.createDelegatingPasswordEncoder(); 
	}

}
