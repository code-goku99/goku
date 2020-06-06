package com.clinic.mongo.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.clinic.mongo.models.collections.PetSet;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;


@Service
public class PetMGServiceWithTemplate {

	private MongoTemplate mongoTemplate;

	public PetMGServiceWithTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public void insert(PetSet petSet) {
		MongoDatabase db = this.mongoTemplate.getDb();
		Set<String> collectionNames = this.mongoTemplate.getCollectionNames();
		this.mongoTemplate.insert(petSet);
	}
	
	public List<PetSet> findAll() {
		 return this.mongoTemplate.findAll(PetSet.class);
			
	} 
	
	public void delete(String id) {
		DeleteResult remove = this.mongoTemplate.remove(new Query(Criteria.where("id").is(id)), PetSet.class);
		System.out.println(remove.getDeletedCount());
	}
}
