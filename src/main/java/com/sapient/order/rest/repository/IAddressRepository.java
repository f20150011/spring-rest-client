package com.sapient.order.rest.repository;

import org.springframework.stereotype.Repository;

import com.sapient.order.rest.dto.Address;

@Repository
public interface IAddressRepository {

	public void save(Address address);
	
}
