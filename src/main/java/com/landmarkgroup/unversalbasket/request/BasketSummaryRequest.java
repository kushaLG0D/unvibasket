package com.landmarkgroup.unversalbasket.request;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BasketSummaryRequest {

	@JsonProperty("store_id")
	private int storeId;

	@JsonProperty("mobile_no")
	private long mobileNo;

	@JsonProperty("shukran_id")
	private String shukranId;

	@JsonProperty("items")
	private List<BasketDetailsRequest> itemList;

	@JsonProperty("created_by")
	private String createdBy;

	@JsonProperty("created_date")
	private LocalDateTime createdDate;

}
