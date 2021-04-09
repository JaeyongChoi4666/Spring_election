package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	      return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//security에서 제외할 url주소 (resources에 해당)
		web.ignoring().antMatchers("/css/**", "/js/**", "/pic/**", "/fonts/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 권한에 따른 페이지 설정
		http.authorizeRequests()
    	.antMatchers("/manager", "/manager/*").hasAuthority("manager")
    	.antMatchers("/election", "/election/*").hasAnyAuthority("student, manager")
		.anyRequest().permitAll() 
    	.and()
    	
    	//로그인 설정
    	.formLogin()
	        .loginPage("/login")  
	        .loginProcessingUrl("/loginProcess")// <form action="여기에" />
	        .usernameParameter("id")       		// <input name="id"
	        .passwordParameter("pw")       		// <input name="pw"
	        .permitAll()						// 모든 사용자 접근가능 	
	        //.defaultSuccessUrl("/election/main?univ_name=")// 로그인 성공시 이동할 페이지
	        .successHandler(new MyLoginHandler())
	        .and()
	    
	    //로그아웃
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/home")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll()
			.and()
			
		// 접근할수 없는 페이지에 대한 처리 403	
		.exceptionHandling()
			.accessDeniedPage("/page403") //접근불가 페이지면 /ROOT/page403으로 이동
			.and();
	}
}
