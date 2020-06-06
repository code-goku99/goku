package com.clinic.mongo.migrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.clinic.mongo.models.collections.PetSet;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

@ChangeLog(order ="001")
public class DataMigrator {

	@ChangeSet(order="001", author = "SANDEEP" , id = "update nbparts")
	public void updateNbParts(@Autowired MongoTemplate template) {
		System.out.println(":::=============:::");
		Criteria crit = new Criteria().orOperator(Criteria.where("nbParts").is(0),
				Criteria.where("nbParts").is(null));
		template.updateMulti(new Query(crit), Update.update("nbParts", 122), PetSet.class);
		
	}
}
