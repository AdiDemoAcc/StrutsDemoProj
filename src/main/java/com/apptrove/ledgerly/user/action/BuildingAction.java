package com.apptrove.ledgerly.user.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.apptrove.ledgerly.user.service.BldngService;
import com.opensymphony.xwork2.ActionSupport;

public class BuildingAction extends ActionSupport{

	private static final long serialVersionUID = 4628794721253433862L;

	private final static Logger logger = LogManager.getLogger(BuildingAction.class);
	
	private final BldngService bldngService;
	
	private Map<String, Object> respObject;

	public Map<String, Object> getRespObject() {
		return respObject;
	}

	public void setRespObject(Map<String, Object> respObject) {
		this.respObject = respObject;
	}
	
	public BuildingAction(BldngService bldngService) {
		super();
		this.bldngService = bldngService;
	}

	public String getBuildingList() {
		try {
			logger.info("Inside getBuildingList method:::::::::::::::::::::::::::::::::::::::::::::::::::");
			respObject = bldngService.getBldngList();
			if (respObject.containsKey("errorCd") && respObject.get("errorCd").equals("000")) {
				logger.info("Exiting getBuildingList method:::::::::::::::::::::::::::::::::::::::::::::::::::");
				return SUCCESS;
			} else {
				addActionError("Something went wrong!!!");
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
	
}
