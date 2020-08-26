package com.example.demo.models;

import java.util.List;

import com.example.demo.dto.PlacementEventsForStudent;
import com.example.demo.dto.StudentDetails;

public class StudentsAndPlacementEvents {
	private List<PlacementEventsForStudent> placementEvents;
	private List<StudentDetails> students;
	
	
	public StudentsAndPlacementEvents() {
	}


	public StudentsAndPlacementEvents(List<StudentDetails> students, List<PlacementEventsForStudent> placementEvents) {
		this.students = students;
		this.placementEvents = placementEvents;
	}


	public List<PlacementEventsForStudent> getPlacementEvents() {
		return placementEvents;
	}


	public void setPlacementEvents(List<PlacementEventsForStudent> placementEvents) {
		this.placementEvents = placementEvents;
	}


	public List<StudentDetails> getStudents() {
		return students;
	}


	public void setStudents(List<StudentDetails> students) {
		this.students = students;
	}
}
