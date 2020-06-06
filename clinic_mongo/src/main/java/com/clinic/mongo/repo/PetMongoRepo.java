package com.clinic.mongo.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.clinic.mongo.models.collections.PetSet;

@Repository
public interface PetMongoRepo extends QuerydslPredicateExecutor<PetSet>, MongoRepository<PetSet,String>  {

	
	@Query(" {'deliveryInfo.deliverFee' : { $lt : ?0 } }")
	public Collection<PetSet> findAllDeliveryLessthan(Integer price);
	
	@Query("{'reviews.rating' :{ $eq : ?0 } }")
	public List<PetSet> findAllReviewEquals(int rating);
	
	public List<PetSet> findAllBy(TextCriteria textCrit);
}
