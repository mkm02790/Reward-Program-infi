package com.reward.customerReward.serviceImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.customerReward.controller.CustomerRewardController;
import com.reward.customerReward.entity.Customer;
import com.reward.customerReward.entity.RewardResponse;
import com.reward.customerReward.service.CustomerRewardServiceInt;
import static com.reward.customerReward.entity.Constants.*;

@Service
public class CustomerRewardServiceImpl implements CustomerRewardServiceInt {

	@Autowired
	Customer customer;

	@Autowired
	RewardResponse rewardResponse;
	
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerRewardController.class);

	@Override
	public RewardResponse processTransaction(Customer customer) {

		int totalRewardPoints = 0;
		rewardResponse.setCustomerId(customer.getCustomerId());
		rewardResponse.setCustomerName(customer.getCustomerName());
		logger.info("Starting Excution of calculateRewardsPoints of CustomerRewardServiceImpl");
		Map<String, Integer> monthsWiseRewardPoints = calculateRewardsPoints(customer.getRewards());
		logger.info("Complete Excution of calculateRewardsPoints of CustomerRewardServiceImpl");
		rewardResponse.setRewardMonthwise(monthsWiseRewardPoints);

		for (int points : monthsWiseRewardPoints.values()) {
			totalRewardPoints += points;
		}
		rewardResponse.setTotalReward(totalRewardPoints);

		return rewardResponse;
	}

	public Map<String, Integer> calculateRewardsPoints(Map<String, Integer> rewards) {

		LinkedHashMap<String, Integer> pointsRecord = new LinkedHashMap<String, Integer>();
		int firstMonthRewardAmount = rewards.getOrDefault("firstMonth", 0);
		int secondMonthRewardAmount = rewards.getOrDefault("secondMonth", 0);
		int thirdMonthRewardAmount = rewards.getOrDefault("thirdMonth", 0);
		logger.info("Starting Excution of transaction of CustomerRewardServiceImpl");
		int firstMonthRewardPoints = transaction(firstMonthRewardAmount);
		int secondMonthRewardPoints = transaction(secondMonthRewardAmount);
		int thirdMonthRewardPoints = transaction(thirdMonthRewardAmount);
		logger.info("Complete Excution of transaction of CustomerRewardServiceImpl");

		pointsRecord.put(FIRSTMONTH, firstMonthRewardPoints);
		pointsRecord.put(SECONDMONTH, secondMonthRewardPoints);
		pointsRecord.put(THIRDMONTH, thirdMonthRewardPoints);

		return pointsRecord;
	}

	public int transaction(int monthlyReward) {
		int amount = monthlyReward;
		int points = 0;

		if (amount > 100) {
			points += (amount - 100) * 2;
			amount = 100;
		}

		if (amount > 50) {
			points += (amount - 50);
		}

		return points;

	}

}
