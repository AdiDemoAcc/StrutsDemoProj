package com.apptrove.ledgerly.user.service;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.apptrove.ledgerly.database.utils.DatabaseUtils;

public class BldngService {
	
	public Map<String, Object> getBldngList() {
		Map<String, Object> respObject = new HashMap<String, Object>();
		try (Session session = DatabaseUtils.getSessionFactory().openSession()){
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return respObject;
	}

}
