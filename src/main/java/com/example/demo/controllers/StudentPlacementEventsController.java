package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.StudentRequestPlacementEventDetails;
import com.example.demo.dto.Data1;
import com.example.demo.dto.PlacementEventsForStudent;
import com.example.demo.dto.PlacementEventsResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentPlacementEventsController {
	
	@Autowired
	WebClient.Builder webClientBuilder;

	HttpHeaders headers = new HttpHeaders();
	
	@RequestMapping(value = "/placement-events", method = RequestMethod.POST)
	public List<PlacementEventsForStudent> addCompany(@RequestBody StudentRequestPlacementEventDetails studentDetails) {
		StudentRequestPlacementEventDetails studDetails = getStudentCgpa(studentDetails.getStudentUsn());
		System.out.println(studDetails.getStudentCgpa());
		List<PlacementEventsForStudent> placementEventsList = getPlacementEvents(new StudentRequestPlacementEventDetails(studDetails.getStudentUsn(), studDetails.getStudentCgpa(), studentDetails.getCollegeId(), studentDetails.getPlacementEventStatus()));
		return placementEventsList;
	}
	
	public StudentRequestPlacementEventDetails getStudentCgpa(String studentUsn) {
		return webClientBuilder.build()
				.get()
				.uri("http://localhost:8220/student-grade/" + studentUsn)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("x-request-id", "stu001")
				.header("Authorization", "stu001")
				.retrieve()
				.bodyToMono(StudentRequestPlacementEventDetails.class)
				.block();
	}
	
	public  List<PlacementEventsForStudent> getPlacementEvents(StudentRequestPlacementEventDetails studentRequestPlacementEventDetails) {
		PlacementEventsResponse response = webClientBuilder.build()
				.post()
				.uri("http://localhost:8084/placement-event/all/student")
				.body(Mono.just(studentRequestPlacementEventDetails), StudentRequestPlacementEventDetails.class)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("x-request-id", "PLE123")
				.header("Authorization", "PLE123")
				.retrieve()
				.bodyToMono(PlacementEventsResponse.class)
				.block();
		
		Data1 data = response.getData();
        List<PlacementEventsForStudent> placementEventsList = data.getResult();
        return placementEventsList;
	}
}
