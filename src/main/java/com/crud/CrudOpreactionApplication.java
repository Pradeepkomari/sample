package com.crud;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CrudOpreactionApplication {
	
	static Logger log = Logger.getLogger(CrudOpreactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudOpreactionApplication.class, args);
	PropertyConfigurator.configure("log4j.properties");
		
		log.info("Information");
		log.warn("Warninng");
		log.error("Error");
		log.debug("Debugginng");
		log.fatal("Fatal");
		
		
	}

}
