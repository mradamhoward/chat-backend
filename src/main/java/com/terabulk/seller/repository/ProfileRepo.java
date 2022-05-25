package com.terabulk.seller.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.terabulk.seller.models.Profile;

public interface ProfileRepo extends MongoRepository<Profile, String> {
	boolean existsByAccountId(String id);
	Profile findByEmail(String emails);
}
