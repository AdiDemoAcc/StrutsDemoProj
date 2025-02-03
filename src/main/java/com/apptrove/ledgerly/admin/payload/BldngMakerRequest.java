package com.apptrove.ledgerly.admin.payload;

import java.util.Date;

public class BldngMakerRequest {

	private Integer bldngId;
	private String bldngName;
	private Integer noOfApartments;
	private Integer makerCd;
	private Date makerDate;
	private String makerRmrks;
	
	public BldngMakerRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public BldngMakerRequest(Integer bldngId, String bldngName, Integer noOfApartments, Integer makerCd, Date makerDt,
			String makerRmrks) {
		super();
		this.bldngId = bldngId;
		this.bldngName = bldngName;
		this.noOfApartments = noOfApartments;
		this.makerCd = makerCd;
		this.makerDate = makerDt;
		this.makerRmrks = makerRmrks;
	}

	public Integer getBldngId() {
		return bldngId;
	}

	public void setBldngId(Integer bldngId) {
		this.bldngId = bldngId;
	}

	public String getBldngName() {
		return bldngName;
	}

	public void setBldngName(String bldngName) {
		this.bldngName = bldngName;
	}

	public Integer getNoOfApartments() {
		return noOfApartments;
	}

	public void setNoOfApartments(Integer noOfApartments) {
		this.noOfApartments = noOfApartments;
	}

	public Integer getMakerCd() {
		return makerCd;
	}

	public void setMakerCd(Integer makerCd) {
		this.makerCd = makerCd;
	}

	public Date getMakerDt() {
		return makerDate;
	}

	public void setMakerDt(Date makerDt) {
		this.makerDate = makerDt;
	}

	public String getMakerRmrks() {
		return makerRmrks;
	}

	public void setMakerRmrks(String makerRmrks) {
		this.makerRmrks = makerRmrks;
	}

	@Override
	public String toString() {
		return "BldngMakerObject [bldngId=" + bldngId + ", bldngName=" + bldngName + ", noOfApartments="
				+ noOfApartments + ", makerCd=" + makerCd + ", makerDt=" + makerDate + ", makerRmrks=" + makerRmrks + "]";
	}
	
	
}
