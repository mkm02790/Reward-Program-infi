package com.reward.customerReward.service;

import com.reward.customerReward.entity.Customer;
import com.reward.customerReward.entity.RewardResponse;

public interface CustomerRewardServiceInt {

	RewardResponse processTransaction(Customer customer);
	
	

}
