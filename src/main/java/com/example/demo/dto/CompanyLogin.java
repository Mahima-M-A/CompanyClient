package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class CompanyLogin {
	private String companyId;
	private String password;
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
