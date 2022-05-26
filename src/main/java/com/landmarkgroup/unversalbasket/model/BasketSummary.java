package com.landmarkgroup.unversalbasket.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "basket_summary")
public class BasketSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "basket_id", nullable = false)
	private long basketId;

	@Column(name = "store_id", nullable = false)
	private long storeId;

	@Column(name = "mobile_no", nullable = false)
	private long mobileNo;

	@Column(name = "shukran_id", nullable = false)
	private String shukranId;

	@Column(name = "business_date", nullable = false)
	private String businessDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "basketSummary")
	@JsonIgnoreProperties("basketSummary")
	private List<BasketDetails> itemList;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "is_fullfilled", nullable = false)
	private boolean isFullFilled;

}
