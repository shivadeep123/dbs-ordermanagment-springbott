package com.dbs.ordermanagesystem.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbs.ordermanagesystem.dto.GenericRequestDTO;
import com.dbs.ordermanagesystem.dto.Header;
import com.dbs.ordermanagesystem.dto.OrderItemDTO;
import com.dbs.ordermanagesystem.model.OrderItem;
import com.dbs.ordermanagesystem.repository.OrderItemRepository;
import com.dbs.ordermanagesystem.util.Utility;

public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	Utility utility;
	public void saveOrderItemDetails(@Valid GenericRequestDTO<Header, OrderItemDTO> request) {
		orderItemRepository.save(OrderItem.builder()
				.productName(request.getTxnResponse().getProductName())
				.productCode(request.getTxnResponse().getProductCode())
				.orderItemNumber(request.getTxnResponse().getOrderItemNumber())
				.quantity(utility.doubleConvert(request.getTxnResponse().getQuantity()))
				.build());
	}
	
}
