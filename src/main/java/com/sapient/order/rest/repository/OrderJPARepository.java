package com.sapient.order.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.order.rest.dto.Order;

@Repository
public interface OrderJPARepository extends JpaRepository<Order, Integer>{

}
