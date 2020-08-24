package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class StudentRequestPlacementEventDetails {
	private String studentUsn, studentCgpa, collegeId, placementEventStatus;

	public StudentRequestPlacementEventDetails() {}
	
	public StudentRequestPlacementEventDetails(String studentUsn, String studentCgpa, String collegeId, String placementEventStatus) {
		this.studentUsn = studentUsn;
		this.studentCgpa = studentCgpa;
		this.collegeId = collegeId;
		this.placementEventStatus = placementEventStatus;
	}

	public String getStudentUsn() {
		return studentUsn;
	}

	public void setStudentUsn(String studentUsn) {
		this.studentUsn = studentUsn;
	}

	public String getStudentCgpa() {
		return studentCgpa;
	}

	public void setStudentCgpa(String studentCgpa) {
		this.studentCgpa = studentCgpa;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getPlacementEventStatus() {
		return placementEventStatus;
	}

	public void setPlacementEventStatus(String placementEventStatus) {
		this.placementEventStatus = placementEventStatus;
	}
}
