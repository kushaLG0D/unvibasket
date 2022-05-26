package com.landmarkgroup.unversalbasket.service;

import com.landmarkgroup.unversalbasket.model.BasketDetails;
import com.landmarkgroup.unversalbasket.model.BasketSummary;
import com.landmarkgroup.unversalbasket.request.BasketDetailsRequest;

public interface BasketDetailsService {
	BasketDetails saveBasketDetails(BasketDetailsRequest bdr, BasketSummary bs);
}
