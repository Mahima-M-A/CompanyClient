package com.example.demo.dto;

import java.util.List;

public class Data1 {
	private List<PlacementEventsForStudent> result;

	public Data1() {
		
	}

	public Data1(List<PlacementEventsForStudent> result) {
		this.result = result;
	}
	
	public List<PlacementEventsForStudent> getResult() {
		return result;
	}
	
	public void setResult(List<PlacementEventsForStudent> result) {
		this.result = result;
	}
	
}
