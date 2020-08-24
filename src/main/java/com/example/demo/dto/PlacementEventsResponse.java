package com.example.demo.dto;

public class PlacementEventsResponse {
	private Data1 data;
	
	public PlacementEventsResponse() {
		
	}

	public PlacementEventsResponse(Data1 data) {
		this.data = data;
	}

	public Data1 getData() {
		return data;
	}

	public void setData(Data1 data) {
		this.data = data;
	}
}
