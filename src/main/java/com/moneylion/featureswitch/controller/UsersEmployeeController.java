package com.moneylion.featureswitch.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.moneylion.featureswitch.entity.UserAccess;
import com.moneylion.featureswitch.entity.UsersEmployee;
import com.moneylion.featureswitch.repo.UsersEmployeeRepo;

@RestController
public class UsersEmployeeController {
	
	private final static Logger logger = LoggerFactory.getLogger(UsersEmployeeController.class);

	@Autowired
	private UsersEmployeeRepo usersEmployeeRepo;

	public UsersEmployeeController(UsersEmployeeRepo usersEmployeeRepo) {
		this.usersEmployeeRepo = usersEmployeeRepo;
	}
	
	@RequestMapping(value = "/feature",
					method = RequestMethod.GET,
					params = { "email", "featureName" },
					produces = MediaType.APPLICATION_JSON_VALUE)
	public UserAccess getCanAccess(@RequestParam("email") String email, 
			@RequestParam("featureName") String featureName) {
		
		UsersEmployee user;
		user = usersEmployeeRepo.findByEmail_Featurename(email, featureName);
		
		if (user != null) {
			UserAccess userAccess = new UserAccess(user.isEnable());		
			return userAccess;
		} else {
			return null;
		}
	}
	
	
	@RequestMapping(value = "/feature",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateFeature(@RequestBody UsersEmployee userEmployee) {

		try {
			if (userEmployee != null) {
				
				UsersEmployee user = usersEmployeeRepo.findByEmail_Featurename
						(userEmployee.getEmail(), userEmployee.getFeatureName());
				user = usersEmployeeRepo.save(user);  //update the users employee details
				return new ResponseEntity<String>(HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
			}
		} catch (Exception e) {
			logger.error("Error during updating user employee details");
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	
}
