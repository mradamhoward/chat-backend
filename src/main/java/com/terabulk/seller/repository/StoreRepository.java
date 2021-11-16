package com.terabulk.seller.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.terabulk.seller.models.ERole;
import com.terabulk.seller.models.Role;
import com.terabulk.seller.models.Store;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {
	Store findByStoreUrl(String url);
}
