package com.landmarkgroup.unversalbasket.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.landmarkgroup.unversalbasket.model.BasketDetails;
import com.landmarkgroup.unversalbasket.model.BasketSummary;
import com.landmarkgroup.unversalbasket.repository.BasketSummaryRepository;
import com.landmarkgroup.unversalbasket.request.BasketDetailsRequest;
import com.landmarkgroup.unversalbasket.request.BasketSummaryRequest;
import com.landmarkgroup.unversalbasket.response.BasketSummaryResponse;
import com.landmarkgroup.unversalbasket.service.BasketDetailsService;
import com.landmarkgroup.unversalbasket.service.BasketSummaryService;

@Service
public class BasketSummaryServiceImpl implements BasketSummaryService {

	private static final boolean isBasketFullFilled = false;

	@Autowired
	private BasketSummaryRepository basketSummaryRepository;

	@Autowired
	private BasketDetailsService basketDetailsService;

	@Override
	public BasketSummaryResponse createBasket(int storeId, String businessDate, BasketSummaryRequest bsr) {
		// Check mobileno and sukhranid is present.
		// We are assuming that mobileno is present.

		BasketSummaryResponse bsres = new BasketSummaryResponse();
		BasketSummary bs = new BasketSummary();
		if (!isBasketFullFilled) {

			bs.setMobileNo(bsr.getMobileNo());
			bs.setStoreId(bsr.getStoreId());
			bs.setShukranId(bsr.getShukranId());
			bs.setBusinessDate(businessDate);
			bs.setCreatedBy(bsr.getCreatedBy());
			bs.setCreatedDate(LocalDateTime.now());
			bs.setFullFilled(isBasketFullFilled);
			List<BasketDetailsRequest> dummy = bsr.getItemList();
			BasketDetailsRequest[] arry = dummy.toArray(new BasketDetailsRequest[dummy.size()]);
			List<BasketDetails> itemList = new ArrayList<>();
			for (int i = 0; i < arry.length; i++) {
				BasketDetails bd = basketDetailsService.saveBasketDetails(arry[i], bs);
				itemList.add(bd);
			}
			bs.setItemList(itemList);
			basketSummaryRepository.save(bs);
			BeanUtils.copyProperties(bs, bsres);

		}
		return bsres;
	}

	@Override
	public List<BasketSummary> getAllBasketSumarry(long mobileno) {

		return basketSummaryRepository.findAllByMobileNo(mobileno);
	}

}
