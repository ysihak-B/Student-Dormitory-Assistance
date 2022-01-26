package com.sda.student_dormitory_assistant.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
@Component

public class AuthenticationuccessHandler implements AuthenticationSuccessHandler{
    private RedirectStrategy strategy = new DefaultRedirectStrategy();
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
            
          Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			if(authority.getAuthority().equals("ROLE_Student")) {
				try {
					strategy.sendRedirect(request, response, "/complains/current");
				} catch (Exception e) {

                    e.printStackTrace();
				}
                
			}else if(authority.getAuthority().equals("ROLE_ADMIN")) {
                try {
					strategy.sendRedirect(request, response, "/complaint");
				} catch (Exception e) {

                    e.printStackTrace();
				}
            }else {
	            throw new IllegalStateException();
	        }
		});

    }
    
}

    

