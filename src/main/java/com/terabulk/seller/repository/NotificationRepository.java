package com.terabulk.seller.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.terabulk.seller.models.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String>{
	List<Notification> findByEmail(String email, Sort sort);
}
