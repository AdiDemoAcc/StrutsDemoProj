package com.apptrove.ledgerly.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.apptrove.ledgerly.admin.models.BUILDING_MST;
import com.apptrove.ledgerly.admin.payload.BldngAuthorRequest;
import com.apptrove.ledgerly.admin.payload.BldngMakerRequest;
import com.apptrove.ledgerly.database.utils.DatabaseUtils;

public class BldngDaoImpl implements BldngDao {

	private static final Logger logger = LogManager.getLogger(BldngDaoImpl.class);
	
	public BldngDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<BUILDING_MST> getAllBuildings() {
		List<BUILDING_MST> bldngList = new ArrayList<BUILDING_MST>();
		try (Session session = DatabaseUtils.getSessionFactory().openSession()){
			logger.info("Inside getAllBuildings method::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			String hql = "FROM BUILDING_MST WHERE isActive=:isActive";
			Query<BUILDING_MST> query = session.createQuery(hql,BUILDING_MST.class);
			bldngList = query.getResultList();
			logger.info("Found "+bldngList.size()+" of buildings::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			logger.info("Exiting getAllBuildings method::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.error("An error occurred: "+e.getMessage());
			e.printStackTrace();
		}
		return bldngList;
	}

	@Override
	public boolean makerBldngMethod(BldngMakerRequest bldngMakerRequest) {
		boolean flag = false;
		BUILDING_MST bldngObj = new BUILDING_MST();
		try (Session session = DatabaseUtils.getSessionFactory().openSession()){
			logger.info("Inside makerBldngMethod method:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
			bldngObj.setBldngName(bldngMakerRequest.getBldngName());
			bldngObj.setNoOfApartments(bldngMakerRequest.getNoOfApartments());
			bldngObj.setMakerId(bldngMakerRequest.getMakerCd());
			bldngObj.setMakerDate(new Date());
			bldngObj.setMakerRmrks(bldngMakerRequest.getMakerRmrks());
			
			Integer res = (Integer) session.save(bldngObj);
			flag = (res != 0 && res != null) ? true : false;
			logger.info("Exiting makerBldngMethod method:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.error("An error occurred: "+e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean authorBldngMethod(BldngAuthorRequest bldngAuthorRequest) {
		BUILDING_MST bldngObj = new BUILDING_MST();
		boolean flag = false;
		try (Session session = DatabaseUtils.getSessionFactory().openSession()){
			logger.info("Inside authorBldngMethod method:::::::::::::::::::::::::::::::::::::::::::::::::::");
			String hql = "FROM BUILDING_MST WHERE bldngId=:bldngId";
			Query<BUILDING_MST> query = session.createQuery(hql,BUILDING_MST.class);
			query.setParameter("bldngId", bldngAuthorRequest.getBldngId());
			bldngObj = query.getSingleResult();
			if (bldngObj == null) {
				throw new RuntimeException("Building Id: "+bldngAuthorRequest.getBldngId()+" not found:::::::::::::::::::::::::::::::::::");
			} else {

				bldngObj.setAuthorId(bldngAuthorRequest.getAuthorCd());
				bldngObj.setAuthorDate(new Date());
				bldngObj.setAuthorRmrks(bldngAuthorRequest.getAuthorRmrks());
				
				session.update(bldngObj);
				flag = true;
			}
			
			logger.info("Exiting authorBldngMethod method:::::::::::::::::::::::::::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.info("An error occurred: "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return flag;
	}

	@Override
	public boolean updateBldngDetails(Integer bldngId) {
		return false;
	}

	@Override
	public boolean deactivateBldngRow(Integer bldngId) {
		boolean flag = false;
		Transaction transaction = null;
		try (Session session = DatabaseUtils.getSessionFactory().openSession()){
			logger.info("Inside updateBldngDetails method:::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
			transaction = session.beginTransaction();
			String hql = "UPDATE BUILDING_MST SET isActive=:isActive WHERE bldngId=:bldngId";
			Query<Integer> query = session.createQuery(hql,Integer.class);
			query.setParameter("isActive", false);
			query.setParameter("bldngId", bldngId);
			Integer res = query.executeUpdate();
			transaction.commit();
			flag = res > 0 ? true : false;
			logger.info("Exiting updateBldngDetails method:::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.error("An error occurred: " + e.getMessage());
			e.printStackTrace();
			return false;
		} 
		return flag;
	}

}
