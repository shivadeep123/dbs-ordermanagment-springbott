package com.dbs.ordermanagesystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name="ORDER")
@Builder(toBuilder = true)
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="ORDER_DATE")
	private Date orderDate;
	@Column(name="SHIPPING_ADDRESS")
	private String shippingAddress;
	@Column(name="ORDER_ITEM_NUMBER")
	private Integer orderItemNumber;
	@Column(name="TOTAL")
	private Double total;
}
