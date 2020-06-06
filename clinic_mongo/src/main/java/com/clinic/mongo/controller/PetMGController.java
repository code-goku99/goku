package com.clinic.mongo.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.mongo.models.collections.DeliveryInfo;
import com.clinic.mongo.models.collections.LegoSetDifficulty;
import com.clinic.mongo.models.collections.PetSet;
import com.clinic.mongo.models.collections.ProductReview;
import com.clinic.mongo.service.PetMGServiceWithRepo;
import com.clinic.mongo.service.PetMGServiceWithTemplate;
import com.clinic.projection.example.AverageRatingModel;
import com.clinic.projection.example.ReportService;

@RestController
@RequestMapping("/mong/pet")
public class PetMGController {

	private PetMGServiceWithTemplate mgService;
	private PetMGServiceWithRepo repoService;
	private ReportService reportService;
	
	
	public PetMGController(PetMGServiceWithTemplate mgService, PetMGServiceWithRepo repoService,
			ReportService reportService) {
		this.mgService = mgService;
		this.repoService = repoService;
		this.reportService = reportService;
	}

	@PostMapping
	public void insert(@RequestBody  PetSet petSet) {
		mgService.insert(petSet);
	}
	@GetMapping("/all")
	public List<PetSet> getAll() {
		 return mgService.findAll();
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		 mgService.delete(id);
	}
	
	@PostMapping("/u/repo")
	public void insertUsingRepo(@RequestBody  PetSet petSet) {
		repoService.insert(petSet);
	}
	@GetMapping("/all/repo/{sort}")
	public List<PetSet> getAllUsingRepo(@PathVariable String sort) {
		if(sort == null || sort.length() > 1) {
		LegoSetDifficulty diff = new LegoSetDifficulty();
		diff.setEasy("med");
		ProductReview review =new ProductReview();
		review.setRating(8);
		DeliveryInfo dinfo = new DeliveryInfo();
		dinfo.setDeliverFee(500);
		PetSet petSet = new PetSet("braun",diff,"Green",Arrays.asList(review),dinfo);
		repoService.insert(petSet);
		return repoService.findAll(false);
		}else {
			return repoService.findAll(true);
		}
		
		 
	}
	@GetMapping("/delete/{id}/repo")
	public void deleteUsingRepo(@PathVariable String id) {
		repoService.delete(id);
	}
	
	@GetMapping("/byDeliveryFee/{price}")
	public Collection<PetSet> byDeliveryFee(@PathVariable int price) {
		
		 return repoService.findAllDeliveryLessthan(price);
	}
	
	@GetMapping("/byReviews/{rating}")
	public Collection<PetSet> byReviewWhichInDocArray(@PathVariable int rating) {
		
		 return repoService.findAllReviewEquals(rating);
	}
	
	/*
	 * 	By DSL in mongo db
	 * */
	@GetMapping("/bestBuy")
	public Collection<PetSet> bestBuy() {
		 return repoService.bestBuy();
	}
	
	@GetMapping("/report")
	public List<AverageRatingModel> getAvgerage(){
		return this.reportService.getAvgReporting();
	}
	
	@GetMapping("/fulltextsearch/{text}")
	public List<PetSet> fulltextsearch(@PathVariable String text){
		//While filtering the text ensure that the field given has @TextIndexed annotation on property
		return this.repoService.fulltextsearch(text);
	}
}
