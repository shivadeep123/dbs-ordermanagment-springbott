package com.dbs.ordermanagesystem.controller;

import javax.validation.Valid;

import org.hibernate.mapping.Map;
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
import com.dbs.ordermanagesystem.dto.OrderItemDTO;
import com.dbs.ordermanagesystem.exception.InvalidRequestException;
import com.dbs.ordermanagesystem.service.OrderItemService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;

@RestController
public class OrderItemController {
	@Autowired
	OrderItemService orderItemService;
	
	@PostMapping(value="/orderItemCreate",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseDTO> createOrderItem
	(@Valid @RequestBody GenericRequestDTO<Header,OrderItemDTO> request, BindingResult result){
		if(result.getErrorCount()>0) {
			throw new InvalidRequestException();
		}		
		orderItemService.saveOrderItemDetails(request);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="productName",
				value="Product Name",
				required=true,
				dataType="string",
				paramType="query"),
		@ApiImplicitParam(name="productCode",
				value="Product Code",
				required=true,
				dataType="string",
				paramType="query"),
		@ApiImplicitParam(name="quantity",
				value="Quantity",
				required=true,
				dataType="string",
				paramType="query")
	})
	@GetMapping("/retrieveOrderItem")
	public ResponseEntity retrieveOrderItems(
			@ApiParam(hidden = true)@RequestParam Map<String, String> queryParam){
		
		
		return ResponseEntity.status(HttpStatus.OK).body("retrieved data via sql");
	}
	
	
}
