package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String firstPage(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String authorizationHeader) {
		return "Hello World";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody CompanyLogin companyLoginDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("ID", companyLoginDetails.getCompanyId());
		claims.put("password", companyLoginDetails.getPassword());
		String jwtToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "secret").compact();
		System.out.println(jwtToken);
		return jwtToken;
	}

}
