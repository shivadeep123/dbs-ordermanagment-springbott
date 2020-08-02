package com.dbs.ordermanagesystem.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermanagesystem.dto.GenericRequestDTO;
import com.dbs.ordermanagesystem.dto.GenericResponseDTO;
import com.dbs.ordermanagesystem.dto.Header;
import com.dbs.ordermanagesystem.dto.OrderDTO;
import com.dbs.ordermanagesystem.exception.InvalidRequestException;
import com.dbs.ordermanagesystem.model.Order;
import com.dbs.ordermanagesystem.repository.OrderRepository;
import com.dbs.ordermanagesystem.service.OrderService;
import com.dbs.ordermanagesystem.util.Utility;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping(value="/orderCreate",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> createOrder
	(@Valid @RequestBody GenericRequestDTO<Header,OrderDTO> request, BindingResult result){
		if(result.getErrorCount()>0) {
			throw new InvalidRequestException();
		}
		orderService.saveOrderDetails(request);
		return ResponseEntity.status(HttpStatus.OK).body("Order saved Successfully");
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="customerName",
				value="Customer Name",
				required=false,
				dataType="string",
				paramType="query"),
		@ApiImplicitParam(name="orderDate",
				value="Order Date",
				required=false,
				dataType="string",
				paramType="query"),
		@ApiImplicitParam(name="shippingAddress",
				value="",
				required=false,
				dataType="string",
				paramType="query"),
		@ApiImplicitParam(name="total",
				value="Total",
				required=false,
				dataType="string",
				paramType="query")
	})
	@GetMapping("/retrieveOrder")
	public ResponseEntity retrieveOrders(
			@ApiParam(hidden = true)@RequestParam Map<String, String> queryParam){
		orderService.retrieveOrders(queryParam);
		
		return ResponseEntity.status(HttpStatus.OK).body("retrieved data via sql");
	}
			

}
