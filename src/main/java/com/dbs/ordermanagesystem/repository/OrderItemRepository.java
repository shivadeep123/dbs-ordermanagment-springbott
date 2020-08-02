package com.dbs.ordermanagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.ordermanagesystem.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{

	
	
}
