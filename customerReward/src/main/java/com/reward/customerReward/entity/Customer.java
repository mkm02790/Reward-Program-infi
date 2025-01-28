package com.reward.customerReward.entity;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Customer {

	private int customerId;
    private String customerName;
    private Map<String, Integer> rewards;
    
    
    public Customer(int customerId, String customerName, Map<String, Integer> rewards) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.rewards = rewards;
        
    }

    
	public Customer() {
		super();
		
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", rewards=" + rewards + "]";
	}


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


	public Map<String, Integer> getRewards() {
		return rewards;
	}


	public void setRewards(Map<String, Integer> rewards) {
		this.rewards = rewards;
	}

	
    
    
}
