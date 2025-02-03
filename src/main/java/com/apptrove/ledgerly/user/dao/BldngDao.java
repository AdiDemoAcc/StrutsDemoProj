package com.apptrove.ledgerly.user.dao;

import java.util.List;

import com.apptrove.ledgerly.admin.models.BUILDING_MST;
import com.apptrove.ledgerly.admin.payload.BldngAuthorRequest;
import com.apptrove.ledgerly.admin.payload.BldngMakerRequest;

public interface BldngDao {

	public List<BUILDING_MST> getAllBuildings();
	
	public boolean makerBldngMethod(BldngMakerRequest bldngMakerRequest);
	
	public boolean authorBldngMethod(BldngAuthorRequest bldngAuthorRequest);
	
	public boolean updateBldngDetails(Integer bldngId);
	
	public boolean deactivateBldngRow(Integer bldngId);
	
}
