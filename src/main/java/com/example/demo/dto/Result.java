package com.example.demo.dto;

public class Result {
	private String companyId, companyName, companyEmail, companyLogo, companyProfile, hiringForBranches;
	public Result() {
		
	}
	public Result(String companyId, String companyName, String companyEmail, String companyLogo, String companyProfile, String hiringForBranches) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyLogo = companyLogo;
		this.companyProfile = companyProfile;
		this.hiringForBranches = hiringForBranches;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getCompanyProfile() {
		return companyProfile;
	}
	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}
	public String getHiringForBranches() {
		return hiringForBranches;
	}
	public void setHiringForBranches(String hiringForBranches) {
		this.hiringForBranches = hiringForBranches;
	}
}