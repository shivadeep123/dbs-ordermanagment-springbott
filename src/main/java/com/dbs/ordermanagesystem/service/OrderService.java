package com.dbs.ordermanagesystem.service;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbs.ordermanagesystem.dto.GenericRequestDTO;
import com.dbs.ordermanagesystem.dto.Header;
import com.dbs.ordermanagesystem.dto.OrderDTO;
import com.dbs.ordermanagesystem.model.Order;
import com.dbs.ordermanagesystem.proxy.OrderItemServicesProxy;
import com.dbs.ordermanagesystem.repository.OrderRepository;
import com.dbs.ordermanagesystem.util.Utility;

public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderItemServicesProxy orderItemServiceProxy;
	@Autowired
	Utility utility;
	public void saveOrderDetails(@Valid GenericRequestDTO<Header, OrderDTO> request) {
		orderRepository.save(Order.builder()
				.customerName(request.getTxnResponse().getCustomerName())
				.orderDate(utility.dateConvert((request.getTxnResponse().getOrderDate())))
				.orderItemNumber(request.getTxnResponse().getOrderItemNumber())
				.total(utility.doubleConvert(request.getTxnResponse().getTotal()))
				.shippingAddress(request.getTxnResponse().getShippingAddress()).build());
		
	}
	public void retrieveOrders(Map<String, String> queryParam) {
		//retrieve corresponding orderItemNumbers from orderTables and call OrderItem via fiegn client
		orderItemServiceProxy.getOrderItem(queryParam);
		return;
	}

}
