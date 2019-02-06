package com.sapient.order.rest.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sapient.order.rest.dto.Order;

@Repository
public interface IOrderRepository {

	void save_(Order order) throws Exception;

	void delete_(Order order);

	Order get_(Order order);

	List<Order> getAllOrder_();

}