package com.apptrove.ledgerly.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.apptrove.ledgerly.admin.models.BUILDING_MST;
import com.apptrove.ledgerly.database.utils.DatabaseUtils;
import com.apptrove.ledgerly.user.dao.BldngDaoImpl;

public class BldngService {
	
	private static final Logger logger = LogManager.getLogger(BldngService.class);
	
	private BldngDaoImpl bldngDaoImpl = new BldngDaoImpl();

	public BldngService() {
		// TODO Auto-generated constructor stub
	}


	public Map<String, Object> getBldngList() {
		Map<String, Object> respObject = new HashMap<String, Object>();
		try (Session session = DatabaseUtils.getSessionFactory().openSession()){
			logger.info("Inside getBldngList method:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			List<BUILDING_MST> bldngList = bldngDaoImpl.getAllBuildings();
			logger.info("Found "+bldngList.size()+" number of buildings");
			if (bldngList != null && !bldngList.isEmpty()) {
				respObject.put("bldngList", bldngList);
				respObject.put("message","success");
				respObject.put("errorCd","000");
			} else {
				respObject.put("message","failed");
				respObject.put("errorCd","001");
			}
			
			logger.info("Exiting getBldngList method:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.info("An error occurred: "+e.getMessage());
			e.printStackTrace();
			respObject.put("message", e.getMessage());
			respObject.put("errorCd","-1");
		}
		return respObject;
	}

}
