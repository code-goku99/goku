package com.clinic.projection.example;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;

import com.clinic.mongo.models.collections.PetSet;

@Service
public class ReportService {
	
	private MongoTemplate mgTemplate;
	
	public ReportService(MongoTemplate mgTemplate) {
		this.mgTemplate = mgTemplate;
	}

	public List<AverageRatingModel> getAvgReporting(){
		
		ProjectionOperation operation = Aggregation.project().
		andExpression("name").as("name").andExpression("{$avg : '$reviews.rating' }").as("avgRating");
	
		TypedAggregation<PetSet> newAggregation = Aggregation.newAggregation(PetSet.class, operation);
		
		AggregationResults<AverageRatingModel> aggregate = mgTemplate.aggregate(newAggregation, AverageRatingModel.class);
		
		return aggregate.getMappedResults();
	}
}
