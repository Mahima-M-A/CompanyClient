package com.example.demo.dto;

public class StudentDetails {
	
	private String studentUsn;
	private String studentName;
	private String studentEmail;
	private String profileImage;
	private String collegeId;

    public String getStudentUsn() {
        return studentUsn;
    }

    public void setStudentUsn(String studentUsn) {
        this.studentUsn = studentUsn;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() { return studentEmail; }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getProfileImage() { return profileImage; }
    
    public void setProfileImage(String profileImage) {
    	this.profileImage = profileImage;
    }
    
	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
}
