package com.reward.customerReward.serviceImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Override
	public RewardResponse processTransaction(Customer customer) {
		System.out.println(customer.getCustomerName());
		System.out.println(customer.getRewards());
		
		int totalRewardPoints = 0;
		rewardResponse.setCustomerId(customer.getCustomerId());
		rewardResponse.setCustomerName(customer.getCustomerName());
		Map<String, Integer> monthsWiseRewardPoints = calculateRewardsPoints(customer.getRewards());
		System.out.println(monthsWiseRewardPoints);
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

		int firstMonthRewardPoints = transaction(firstMonthRewardAmount);
		int secondMonthRewardPoints = transaction(secondMonthRewardAmount);
		int thirdMonthRewardPoints = transaction(thirdMonthRewardAmount);

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
