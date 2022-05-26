package com.landmarkgroup.unversalbasket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.landmarkgroup.unversalbasket.model.BasketSummary;

public interface BasketSummaryRepository extends JpaRepository<BasketSummary, Long> {

	List<BasketSummary> findAllByMobileNo(long mobileno);
}
