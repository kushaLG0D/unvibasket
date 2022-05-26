package com.landmarkgroup.unversalbasket.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landmarkgroup.unversalbasket.model.BasketDetails;
import com.landmarkgroup.unversalbasket.model.BasketSummary;
import com.landmarkgroup.unversalbasket.repository.BasketDetailsRepository;
import com.landmarkgroup.unversalbasket.request.BasketDetailsRequest;
import com.landmarkgroup.unversalbasket.service.BasketDetailsService;

@Service
public class BasketDetailsServiceImpl implements BasketDetailsService {

	private static final String itemDesc = "itemdesc";
	private static final String itemPriceUrl = "https://192.168.31.23:8444/sahlasell/v1/item/itemLookup?token={token}";
	private static final double itemPrice = 100.10;
	@Autowired
	private BasketDetailsRepository basketDetailsRepository;

	@Autowired
	private RestTemplate restTemplate;

	public double getItemPrice(String itembarcode) {

		Map<String, Object> urivariables = new HashMap<>();
		urivariables.put("token", "test");

		Map<String, Object> body = new HashMap<>();
		body.put("barCodeScanned", true);
		body.put("itemDescription", "string");
		body.put("itemID", "6292160933517");
		body.put("searchCriteria", "string");
		ObjectMapper om = new ObjectMapper();

		String o = restTemplate.postForObject(itemPriceUrl, "", String.class, urivariables);
		return 0.00;
	}

	@Override
	public BasketDetails saveBasketDetails(BasketDetailsRequest bdr, BasketSummary bs) {
		BasketDetails bd = new BasketDetails();
		bd.setItemCode(bdr.getItemCode());
		bd.setItemDesc(itemDesc);
		bd.setItemPrice(itemPrice);
		bd.setItemQuantity(bdr.getItemQuantity());
		bd.setCreatedBy(bdr.getCreatedBy());
		bd.setCreatedDate(LocalDateTime.now());
		bd.setBasketSummary(bs);
		basketDetailsRepository.save(bd);
		return bd;
	}

}
