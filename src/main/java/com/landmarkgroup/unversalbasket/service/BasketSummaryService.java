package com.landmarkgroup.unversalbasket.service;

import java.util.List;

import com.landmarkgroup.unversalbasket.model.BasketSummary;
import com.landmarkgroup.unversalbasket.request.BasketSummaryRequest;
import com.landmarkgroup.unversalbasket.response.BasketSummaryResponse;

public interface BasketSummaryService {

	BasketSummaryResponse createBasket(int storeId,String businessDate,BasketSummaryRequest bsr);
	
	List<BasketSummary> getAllBasketSumarry(long mobileno);
}
