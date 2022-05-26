package com.landmarkgroup.unversalbasket.response;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.landmarkgroup.unversalbasket.model.BasketDetails;

import lombok.Data;

@Data
public class BasketSummaryResponse {

	@JsonProperty("basket_id")
	private long basketId;

	@JsonProperty("store_id")
	private long storeId;

	@JsonProperty("mobile_no")
	private long mobileNo;

	@JsonProperty("shukran_id")
	private String shukranId;

	@JsonProperty("items")
	private List<BasketDetails> itemList;

	@JsonProperty("is_fullfilled")
	private boolean isFullFilled;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

}
