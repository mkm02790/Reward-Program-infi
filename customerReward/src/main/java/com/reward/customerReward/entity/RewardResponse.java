package com.reward.customerReward.entity;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class RewardResponse {

	private int customerId;
	private String customerName;
	private Map<String, Integer> rewardMonthwise;
	private int totalReward;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Map<String, Integer> getRewardMonthwise() {
		return rewardMonthwise;
	}

	public void setRewardMonthwise(Map<String, Integer> rewardMonthwise) {
		this.rewardMonthwise = rewardMonthwise;
	}

	public int getTotalReward() {
		return totalReward;
	}

	public void setTotalReward(int totalReward) {
		this.totalReward = totalReward;
	}

	@Override
	public String toString() {
		return "RewardResponse [customerId=" + customerId + ", customerName=" + customerName + ", rewardMonthwise="
				+ rewardMonthwise + ", totalReward=" + totalReward + "]";
	}

	public RewardResponse(int customerId, String customerName, Map<String, Integer> rewardMonthwise, int totalReward) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.rewardMonthwise = rewardMonthwise;
		this.totalReward = totalReward;
	}

	public RewardResponse() {
		super();
		
	}
    
	
}
