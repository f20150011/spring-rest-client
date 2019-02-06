package com.sapient.order.rest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.order.rest.dto.Address;
import com.sapient.order.rest.dto.Order;
import com.sapient.order.rest.repository.IAddressRepository;
import com.sapient.order.rest.repository.OrderJPARepository;

@Service
public class OrderServiceImpl implements IOrderService {
	
	//private IOrderRepository orderRepositoryImpl;
	@Autowired
	private OrderJPARepository orderRepositoryImpl;
	@Autowired
	private IAddressRepository addressRepositoryImpl;
	
	public OrderServiceImpl() {
		System.out.println("OrderServiceImpl bean created");
	}

	/**
	 * 
	 * @param order
	 * @return order id
	 * @throws Exception 
	 */
	@Transactional(rollbackOn=Exception.class, dontRollbackOn=IllegalAccessException.class)
	public int processOrder(Order order) throws Exception {
		orderRepositoryImpl.save(order);
		Address address = new Address();
		address.setPin(500028);
		address.setState("Hyderabad");
		addressRepositoryImpl.save(address);
		return order.getId();
	}

	public OrderJPARepository getOrderRepositoryImpl() {
		return orderRepositoryImpl;
	}

	@Transactional
	public void deleteOrder(int id) {
		Order order = new Order();
		order.setId(id);
		orderRepositoryImpl.delete(order);
	}

	@Transactional
	public Order getOrder(int id) {
		Order order = new Order();
		order.setId(id);
		return orderRepositoryImpl.getOne(id);
	}

	@Transactional
	public List<Order> getAllOrder() {
		return orderRepositoryImpl.findAll();
	}

	@Transactional
	public void deleteAllOrder() {
		orderRepositoryImpl.deleteAll();
	}
}
