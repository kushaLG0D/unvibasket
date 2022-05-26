package com.landmarkgroup.unversalbasket.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BasketDetailsRequest {

	@JsonProperty("item_code")
	private String itemCode;

	@JsonProperty("item_quantity")
	private int itemQuantity;

	@JsonProperty("created_by")
	private String createdBy;

	@JsonProperty("created_date")
	private LocalDateTime createdDate;

}
