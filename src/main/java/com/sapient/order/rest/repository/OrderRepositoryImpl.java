package com.sapient.order.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sapient.order.rest.dto.Order;

@Repository
public class OrderRepositoryImpl implements IOrderRepository {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save_(Order order) throws Exception {
		entityManager.persist(order);
	}

	@Override
	public void delete_(Order order) {
		entityManager.remove(entityManager.merge(order));
	}

	@Override
	public Order get_(Order order) {
		return entityManager.find(Order.class, order.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrder_() {
		Query query = entityManager.createQuery("from orders");
		return query.getResultList();
	}

}
