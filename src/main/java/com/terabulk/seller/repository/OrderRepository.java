package com.terabulk.seller.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.terabulk.seller.models.Order;

public interface OrderRepository extends MongoRepository<Order, String>{
	List<Order> findByEmail(String email, Sort sort);
}
