package com.dbs.ordermanagesystem.repository;

import javax.persistence.criteria.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long>{

	void save(com.dbs.ordermanagesystem.model.Order build);

}
