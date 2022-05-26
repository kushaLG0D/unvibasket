package com.landmarkgroup.unversalbasket.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "basket_details")
public class BasketDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "item_code", nullable = false)
	private String itemCode;

	@Column(name = "item_desc", nullable = false)
	private String itemDesc;

	@Column(name = "item_price", nullable = false)
	private double itemPrice;

	@Column(name = "item_quantity", nullable = false)
	private long itemQuantity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("itemList")
	private BasketSummary basketSummary;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;
}
