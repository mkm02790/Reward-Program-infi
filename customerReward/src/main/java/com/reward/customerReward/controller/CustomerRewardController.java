package com.reward.customerReward.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reward.customerReward.entity.Customer;
import com.reward.customerReward.entity.RewardResponse;
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
	{
		rewardResponse = customerRewardServiceInt.processTransaction(customer);
		return ResponseEntity.status(HttpStatus.OK).body(rewardResponse);

	}

}
