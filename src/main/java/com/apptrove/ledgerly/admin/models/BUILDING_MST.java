package com.apptrove.ledgerly.admin.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "com_ldgr_bldng_mst")
public class BUILDING_MST implements Serializable{

	private static final long serialVersionUID = -5238407363367770060L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bldng_id")
	private Integer bldngId;
	
	@Column(name = "bldng_name")
	private String bldngName;
	
	@Column(name = "bldng_block")
	private String bldngBlock;
	
	@Column(name = "no_of_apartments")
	private Integer noOfApartments;
	
	@Column(name = "no_of_floors")
	private Integer noOfFloors;
	
	@Column(name = "no_of_lifts")
	private Integer noOfLifts;
	
	@Column(name = "reception")
	private Integer reception;
	
	@Column(name = "maker_id")
	private Integer makerId;
	
	@Column(name = "maker_date")
	private Date makerDate;
	
	@Column(name = "maker_rmrks")
	private String makerRmrks;
	
	@Column(name = "author_id")
	private Integer authorId;
	
	@Column(name = "author_date")
	private Date authorDate;
	
	@Column(name = "author_rmrks")
	private String authorRmrks;
	
	@Column(name = "auth_status")
	private Integer authStatus;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	public BUILDING_MST() {
		// TODO Auto-generated constructor stub
	}

	public BUILDING_MST(Integer bldngId, String bldngName, String bldngBlock, Integer noOfApartments,
			Integer noOfFloors, Integer noOfLifts, Integer reception, Integer makerId, Date makerDate,
			String makerRmrks, Integer authorId, Date authorDate, String authorRmrks, Integer authStatus,
			boolean isActive) {
		super();
		this.bldngId = bldngId;
		this.bldngName = bldngName;
		this.bldngBlock = bldngBlock;
		this.noOfApartments = noOfApartments;
		this.noOfFloors = noOfFloors;
		this.noOfLifts = noOfLifts;
		this.reception = reception;
		this.makerId = makerId;
		this.makerDate = makerDate;
		this.makerRmrks = makerRmrks;
		this.authorId = authorId;
		this.authorDate = authorDate;
		this.authorRmrks = authorRmrks;
		this.authStatus = authStatus;
		this.isActive = isActive;
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

	public String getBldngBlock() {
		return bldngBlock;
	}

	public void setBldngBlock(String bldngBlock) {
		this.bldngBlock = bldngBlock;
	}

	public Integer getNoOfApartments() {
		return noOfApartments;
	}

	public void setNoOfApartments(Integer noOfApartments) {
		this.noOfApartments = noOfApartments;
	}

	public Integer getMakerId() {
		return makerId;
	}

	public void setMakerId(Integer makerId) {
		this.makerId = makerId;
	}

	public Date getMakerDate() {
		return makerDate;
	}

	public void setMakerDate(Date makerDate) {
		this.makerDate = makerDate;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Date getAuthorDate() {
		return authorDate;
	}

	public void setAuthorDate(Date authorDate) {
		this.authorDate = authorDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}

	public String getMakerRmrks() {
		return makerRmrks;
	}

	public void setMakerRmrks(String makerRmrks) {
		this.makerRmrks = makerRmrks;
	}

	public String getAuthorRmrks() {
		return authorRmrks;
	}

	public void setAuthorRmrks(String authorRmrks) {
		this.authorRmrks = authorRmrks;
	}
	
	public Integer getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(Integer noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public Integer getNoOfLifts() {
		return noOfLifts;
	}

	public void setNoOfLifts(Integer noOfLifts) {
		this.noOfLifts = noOfLifts;
	}

	public Integer getReception() {
		return reception;
	}

	public void setReception(Integer reception) {
		this.reception = reception;
	}
	
	@Override
	public String toString() {
		return "BUILDING_MST [bldngId=" + bldngId + ", bldngName=" + bldngName + ", bldngBlock=" + bldngBlock
				+ ", noOfApartments=" + noOfApartments + ", noOfFloors=" + noOfFloors + ", noOfLifts=" + noOfLifts
				+ ", reception=" + reception + ", makerId=" + makerId + ", makerDate=" + makerDate + ", makerRmrks="
				+ makerRmrks + ", authorId=" + authorId + ", authorDate=" + authorDate + ", authorRmrks=" + authorRmrks
				+ ", authStatus=" + authStatus + ", isActive=" + isActive + "]";
	}

	public String bldngJSON() {
		return "{"
			 + "\"bldngId\":\"" + bldngId + "\","
			 + "\"bldngName\":\"" + escapeJSON(bldngName) + "\","
			 + "\"bldngBlock\":\"" + escapeJSON(bldngBlock) + "\","
			 + "\"noOfApartments\":\"" + noOfApartments + "\","
			 + "\"noOfFloors\":\"" + noOfFloors + "\","
			 + "\"noOfLifts\":\"" + noOfLifts + "\","
			 + "\"reception\":\"" + reception + "\","
			 + "\"makerId\":\"" + makerId + "\","
			 + "\"makerDt\":\"" + makerDate + "\","
			 + "\"makerRmrks\":\"" + escapeJSON(makerRmrks) + "\","
			 + "\"authorId\":\"" + authorId + "\","
			 + "\"authorDt\":\"" + authorDate + "\","
			 + "\"authorRmrks\":\"" + escapeJSON(authorRmrks) +"\""
			 + "}";
	}
	
	public String escapeJSON(String str) {
		if (str == null) {
			return "";
		}
		return str.replace("\"","\\\"");
	}
}
