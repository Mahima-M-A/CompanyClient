package com.example.demo.dto;

public class PlacementEventsForStudent {

    private String placementEventId, placementEventDate, companyId, companyName, companyLogo;
    
    public PlacementEventsForStudent(String placementEventId, String placementEventDate, String companyId,
			String companyName, String companyLogo) {
		this.placementEventId = placementEventId;
		this.placementEventDate = placementEventDate;
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyLogo = companyLogo;
	}

	public String getPlacementEventId() {
        return placementEventId;
    }

    public void setPlacementEventId(String placementEventId) {
        this.placementEventId = placementEventId;
    }

    public String getPlacementEventDate() {
        return placementEventDate;
    }

    public void setPlacementEventDate(String placementEventDate) {
        this.placementEventDate = placementEventDate;
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

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

}
