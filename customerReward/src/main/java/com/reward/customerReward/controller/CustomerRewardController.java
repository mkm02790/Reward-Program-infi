package com.reward.customerReward.controller;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reward.customerReward.entity.Customer;
import com.reward.customerReward.entity.RewardResponse;
import com.reward.customerReward.exception.InvalidCustomerRequestException;
import com.reward.customerReward.exception.InvalidProcessedResponse;
import com.reward.customerReward.service.CustomerRewardServiceInt;


@RestController
@RequestMapping("/reward")
public class CustomerRewardController {

	@Autowired
	CustomerRewardServiceInt customerRewardServiceInt;

	@Autowired
	RewardResponse rewardResponse;

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerRewardController.class);


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RewardResponse> calCulateCustomerReward(@RequestBody Customer customer)
			throws InvalidProcessedResponse, InvalidCustomerRequestException {

		try {
			if (customer == null);
		} 
		catch (NullPointerException e) {
			logger.error("Null pointer Exception occurred Because of customer is NULL", e);
			throw new InvalidCustomerRequestException("Invalid input, customer data is required");
		}
		logger.info("Excuting processTransaction at controller layer");
		rewardResponse = customerRewardServiceInt.processTransaction(customer);
		logger.info("Excution complete at processTransaction at controller layer");
		try {
			if (rewardResponse == null);
		}
		catch (NullPointerException e) {
			logger.error("Null pointer Exception occurred Because of rewardResponse is NULL", e);
			throw new InvalidProcessedResponse("An error occurred while processing the reward");
		}
		return ResponseEntity.status(HttpStatus.OK).body(rewardResponse);

	}

}
