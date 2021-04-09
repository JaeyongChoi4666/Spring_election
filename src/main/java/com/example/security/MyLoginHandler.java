package com.example.security;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MyLoginHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		MyUser user = (MyUser) authentication.getPrincipal();
		
		if(user != null) {
			Collection<GrantedAuthority> roles = user.getAuthorities();
			for(GrantedAuthority tmp : roles) { 
				String url = "";
				final String param = URLEncoder.encode(user.getUniv_name(), "utf-8");
				
				if (tmp.getAuthority().equals("student")) {
					// request.getContextPath() =>  ROOT
					url = request.getContextPath() + "/election/main?univ_name=" + param;
				}
				else if (tmp.getAuthority().equals("manager")) {
					url = request.getContextPath() + "/election/main?univ_name=" + param;
				}
				//페이지 이동하기
				response.sendRedirect(url);
			}
		}
	}
	
	
}
