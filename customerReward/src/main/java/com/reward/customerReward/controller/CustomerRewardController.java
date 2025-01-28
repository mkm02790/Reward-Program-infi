package com.reward.customerReward.controller;

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

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RewardResponse> calCulateCustomerReward(@RequestBody Customer customer)
			throws InvalidCustomerRequestException, InvalidProcessedResponse {
		if (customer == null) {
			throw new InvalidCustomerRequestException("Invalid input, customer data is required");
		}
		rewardResponse = customerRewardServiceInt.processTransaction(customer);
		if (rewardResponse == null) {
			throw new InvalidProcessedResponse("An error occurred while processing the reward");
		}
		return ResponseEntity.status(HttpStatus.OK).body(rewardResponse);

	}

}
