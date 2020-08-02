package com.dbs.ordermanagesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name="ORDER_ITEM")
@Builder(toBuilder = true)
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_ITEM_NUMBER")
	private long orderItemNumber;
	@Column(name="PRODUCT_CODE")
	private String productCode;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="QUANTITY")
	private Double quantity;
}
