package com.clinic.mongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.Mongobee;

@Configuration
@PropertySource(value = { "classpath:application-mon_dev.properties" })
public class MongoBeeConfig {

	@Autowired
	MongoTemplate mgTemplate;
	@Autowired
	private Environment environment;
	
	@Value("${spring.data.mongodb.database}")
	private final String databaseName=null;
	
	
	
	@Bean(name = "mongoBee")
	public Mongobee mongoBeeConfig() {
		Mongobee runner = new Mongobee(environment.getProperty("mongo.uri"));
		//runner.setDbName(databaseName);
		runner.setMongoTemplate(mgTemplate);
		runner.setChangeLogsScanPackage(environment.getProperty("application.property.mongobee.changelog.path"));//    This identifies the chnage log class(DataMigrator)
		return runner;
	}
}
//The bean 'mongoBeeConfig', defined in class path resource [com/clinic/mongo/config/MongoBeeConfig.class], could not be registered. A bean with that name has already been defined in file [D:\Deepu\Deepu-petclinic\petclinic_mongo\target\classes\com\clinic\mongo\config\MongoBeeConfig.class] and overriding is disabled.
//both bean and class name are same so add @Bean(name) name attribute