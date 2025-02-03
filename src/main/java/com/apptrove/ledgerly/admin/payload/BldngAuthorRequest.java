package com.apptrove.ledgerly.admin.payload;

import java.util.Date;

public class BldngAuthorRequest {

	private Integer bldngId;
	private Integer authorCd;
	private Date authorDate;
	private String authorRmrks;
	
	public BldngAuthorRequest() {
		// TODO Auto-generated constructor stub
	}

	public BldngAuthorRequest(Integer bldngId, Integer authorCd, Date authorDt, String authorRmrks) {
		super();
		this.bldngId = bldngId;
		this.authorCd = authorCd;
		this.authorDate = authorDt;
		this.authorRmrks = authorRmrks;
	}

	public Integer getBldngId() {
		return bldngId;
	}

	public void setBldngId(Integer bldngId) {
		this.bldngId = bldngId;
	}

	public Integer getAuthorCd() {
		return authorCd;
	}

	public void setAuthorCd(Integer authorCd) {
		this.authorCd = authorCd;
	}

	public Date getAuthorDt() {
		return authorDate;
	}

	public void setAuthorDt(Date authorDt) {
		this.authorDate = authorDt;
	}

	public String getAuthorRmrks() {
		return authorRmrks;
	}

	public void setAuthorRmrks(String authorRmrks) {
		this.authorRmrks = authorRmrks;
	}

	@Override
	public String toString() {
		return "BldngAuthorRequest [bldngId=" + bldngId + ", authorCd=" + authorCd + ", authorDate=" + authorDate
				+ ", authorRmrks=" + authorRmrks + "]";
	}
	
	
	
}
