package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


@Component
public class AuthorizationFilter extends OncePerRequestFilter implements Ordered{

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain filterChain)
			throws ServletException, IOException {
		try {
            Optional<String> existingAuthorization = getAuthorizationFromHeaders(httpRequest);
            String authorizationToken;
            //String validUsers[] = {"COM123", "PLE123"}; 
            if (existingAuthorization.isPresent()) {
                authorizationToken = existingAuthorization.get();
                /*if (!Arrays.stream(validUsers).anyMatch(authorization::equalsIgnoreCase)) {
                	httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
                } else {
                	filterChain.doFilter(httpRequest, httpResponse);
                }*/
                
                try {
        			SecurityContext context = SecurityContextHolder.getContext();

        			if(authorizationToken != null && authorizationToken.startsWith("Bearer")) {

        				final String bearerTkn= authorizationToken.replaceAll("Bearer", "");
        				System.out.println("Following token is received from the protected url: " + bearerTkn);

        				try {
        					Jws<Claims> claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(bearerTkn);
        					String ID= (String) claims.getBody().get("ID");
        					String password= (String) claims.getBody().get("password");
        					
        					List<GrantedAuthority> authority= new ArrayList<GrantedAuthority>();
        					authority.add(new SimpleGrantedAuthority(password));
        					MyAuthToken authenticationTkn= new MyAuthToken(ID, null, authority);
        					context.setAuthentication(authenticationTkn);
        				} catch (SignatureException e) {
        					httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid token");
        					throw new ServletException();
        				}
        			}

        			filterChain.doFilter(httpRequest, httpResponse);
        			context.setAuthentication(null);
        		} catch(AuthenticationException ex) {
        			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
        		}
            }
        } finally {
        	System.out.println("Filter executed");
        }
    }

    public Optional<String> getAuthorizationFromHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        for (String headerName : Collections.list(headerNames)) {
            headerName = StringEscapeUtils.escapeHtml4(headerName);
            if (headerName.equalsIgnoreCase(HttpHeaders.AUTHORIZATION)) {
                Enumeration<String> values = request.getHeaders(headerName);
                ArrayList<String> valuesList = Collections.list(values);
                if (valuesList != null) {
                    String value = StringEscapeUtils.escapeHtml4(valuesList.get(0));
                    return StringUtils.isEmpty(value.trim()) ? Optional.empty() : Optional.of(value);
                }
            }
        }

        return Optional.empty();
    }
	
}