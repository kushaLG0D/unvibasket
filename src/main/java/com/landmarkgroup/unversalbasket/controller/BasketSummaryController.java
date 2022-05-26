package com.landmarkgroup.unversalbasket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.landmarkgroup.unversalbasket.model.BasketSummary;
import com.landmarkgroup.unversalbasket.request.BasketSummaryRequest;
import com.landmarkgroup.unversalbasket.response.BasketSummaryResponse;
import com.landmarkgroup.unversalbasket.service.BasketSummaryService;

@RestController
@RequestMapping("/api/universalbasket")
public class BasketSummaryController {

	@Autowired
	private BasketSummaryService basketSummaryService;

	@PostMapping("/{storeId}/{businessDate}")
	public BasketSummaryResponse saveBasketSummary(@PathVariable int storeId, @PathVariable String businessDate,
			@RequestBody BasketSummaryRequest bsr) {
		return basketSummaryService.createBasket(storeId, businessDate, bsr);
	}

	@GetMapping("/{mobileno}")
	public List<BasketSummary> getllBasketSummary(@PathVariable long mobileno) {
		return basketSummaryService.getAllBasketSumarry(mobileno);
	}

}
