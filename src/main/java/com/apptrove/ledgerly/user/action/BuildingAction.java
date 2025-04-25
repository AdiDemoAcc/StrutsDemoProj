package com.apptrove.ledgerly.user.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.apptrove.ledgerly.admin.models.BUILDING_MST;
import com.apptrove.ledgerly.admin.payload.BldngMakerRequest;
import com.apptrove.ledgerly.user.service.BldngService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuildingAction extends ActionSupport{

	private static final long serialVersionUID = 4628794721253433862L;

	private final static Logger logger = LogManager.getLogger(BuildingAction.class);
	
	private BldngMakerRequest building;
	
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

	public BldngMakerRequest getBuilding() {
		return building;
	}

	public void setBuilding(BldngMakerRequest building) {
		this.building = building;
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
		HttpServletRequest httpRequest = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = httpRequest.getSession();
		try {
			if (building != null) {
				if (session.getAttribute("user") == null) {
					respObject.put("status", "failed");
					respObject.put("message", "Maker User Session Expired");
					respObject.put("errorCode", "001");
					return ERROR;
				}
				boolean flag = bldngService.addNewBuilding(building);
				if (flag) {
					respObject.put("status", "success");
					respObject.put("message", "Data added successfully");
					respObject.put("errorCode", "000");
					return SUCCESS;
				} else {
					respObject.put("status", "failed");
					respObject.put("message", "Somthing went wrong");
					respObject.put("errorCode", "002");
				}
			}
		} catch (Exception e) {
			addActionError("Somthing went wrong.");
			logger.error("An error occurred: {}",e.getMessage());
			e.printStackTrace();
			respObject.put("status", "failed");
			respObject.put("message", e.getMessage());
			respObject.put("errorCode", "001");
			return ERROR;
		}
		return ERROR;
	}
	
}
