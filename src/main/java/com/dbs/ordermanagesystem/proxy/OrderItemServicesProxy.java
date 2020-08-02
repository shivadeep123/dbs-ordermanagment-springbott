package com.dbs.ordermanagesystem.proxy;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbs.ordermanagesystem.dto.GenericResponseDTO;

@FeignClient(value="order-item" , url = "localhost:8080")
public interface OrderItemServicesProxy {

	@GetMapping("/retrieveOrderItem")
	GenericResponseDTO getOrderItem(@RequestParam Map<String,String> orderItemDetails);
}
