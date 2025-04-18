package com.apptrove.ledgerly.user.action;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.apptrove.ledgerly.admin.models.BUILDING_MST;
import com.apptrove.ledgerly.user.service.BldngService;
import com.opensymphony.xwork2.ActionSupport;

public class BuildingAction extends ActionSupport{

	private static final long serialVersionUID = 4628794721253433862L;

	private final static Logger logger = LogManager.getLogger(BuildingAction.class);
	
	private BldngService bldngService = new BldngService();
	
	private List<BUILDING_MST> bldngList; 
	
	private Map<String, Object> respObject;

	public Map<String, Object> getRespObject() {
		return respObject;
	}

	public void setRespObject(Map<String, Object> respObject) {
		this.respObject = respObject;
	}

	public List<BUILDING_MST> getBldngList() {
		return bldngList;
	}

	public void setBldngList(List<BUILDING_MST> bldngList) {
		this.bldngList = bldngList;
	}

	public String getBuildingList() {
		try {
			logger.info("Inside getBuildingList method:::::::::::::::::::::::::::::::::::::::::::::::::::");
			respObject = bldngService.getBldngList();
			if (respObject.containsKey("errorCd") && respObject.get("errorCd").equals("000")) {
				bldngList = (List<BUILDING_MST>) respObject.get("bldngList");
//				addActionError("Found Buildings");
				logger.info("Exiting getBuildingList method:::::::::::::::::::::::::::::::::::::::::::::::::::");
				return SUCCESS;
			} else {
				addActionError("No buildings found");
				logger.info("Exiting getBuildingList method:::::::::::::::::::::::::::::::::::::::::::::::::::");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("Something went wrong!!!");
			logger.error("An error occurred: "+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String getBldngAuthList() {
		return null;
	}
	
	public String bldngMaker() {
		try {
			return SUCCESS;
		} catch (Exception e) {
			addActionError("Somthing went wrong.");
			logger.error("An error occurred: {}",e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
