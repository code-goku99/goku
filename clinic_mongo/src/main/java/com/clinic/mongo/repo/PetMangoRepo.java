package com.clinic.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clinic.mongo.models.collections.PetSet;

@Repository
public interface PetMangoRepo extends MongoRepository<PetSet,Integer> {

}
