package com.clinic.mongo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.clinic.mongo.models.collections.PetSet;
import com.clinic.mongo.models.collections.QPetSet;
import com.clinic.mongo.repo.PetMongoRepo;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class PetMGServiceWithRepo {

		private PetMongoRepo repo;

		public PetMGServiceWithRepo(PetMongoRepo repo) {
			this.repo = repo;
		}
		
		public void insert(PetSet petSet) {
			this.repo.insert(petSet);
		}
		
		public List<PetSet> findAll(boolean isSort) {
			if(!isSort)
			 return this.repo.findAll();
			else {
				Sort sortByName = Sort.by("name").ascending();
				return this.repo.findAll(sortByName);
			}
				
		} 
		
		public void delete(String id) {
			this.repo.deleteById(id);
		}
		
		
		public Collection<PetSet> findAllDeliveryLessthan(int price){
			
			//db.getCollection('pet_set').find({"deliveryInfo.deliverFee" : { $lt :500} })
			return this.repo.findAllDeliveryLessthan(price);
		}
		
		public Collection<PetSet> findAllReviewEquals(int rating){
			
			//db.getCollection('pet_set').find({'reviews.rating' :{ $eq : 8 } })
			return this.repo.findAllReviewEquals(rating);
		}
		
		public List<PetSet> bestBuy(){
			// these are generated classes.
			QPetSet petSet = new QPetSet("petSet");
			BooleanExpression inStock = petSet.deliveryInformation.inStock.isTrue();
			Predicate fee =  petSet.deliveryInformation.deliverFee.lt(50);
			Predicate reviews =  petSet.reviews.any().rating.gt(8);
			
			Predicate bestBuy =inStock.and(fee).and(reviews);
			//we have extends QuerydslPredicateExecutor at repo to get method findAll(predicate)
			
			return (List<PetSet>) this.repo.findAll(bestBuy);
		}
		
		public List<PetSet> fulltextsearch(String fullText){
			TextCriteria textCrit = TextCriteria.forDefaultLanguage().matching(fullText);
			return this.repo.findAllBy(textCrit);
		}
}
