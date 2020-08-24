package com.example.demo.dto;

public class CompanyResponse {
	private Data data;
	
	public CompanyResponse() {
		
	}

	public CompanyResponse(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
