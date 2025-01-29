package com.reward.customerReward.serviceImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.reward.customerReward.entity.Customer;
import com.reward.customerReward.entity.RewardResponse;
import com.reward.customerReward.serviceImpl.CustomerRewardServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerRewardServiceImplTest {

	@InjectMocks
	private CustomerRewardServiceImpl customerRewardServiceImpl;

	@Mock
	private Customer customer;

	@BeforeEach
	void setUp() {
		when(customer.getCustomerId()).thenReturn(1);
		when(customer.getCustomerName()).thenReturn("Mukul Maurya");
		when(customer.getRewards()).thenReturn(Map.of("firstMonth", 1320, "secondMonth", 90, "thirdMonth", 200));
	}

	@Test
	void testProcessTransaction() {
		RewardResponse result = customerRewardServiceImpl.processTransaction(customer);
		assertNotNull(result);
		assertEquals(1, result.getCustomerId());
		assertEquals("Mukul Maurya", result.getCustomerName()); 
		assertNotNull(result.getRewardMonthwise());
		assertEquals(2780, result.getTotalReward());  
	}

	@Test
	void testCalculateRewardsPoints() {
		
		Map<String, Integer> rewards = Map.of("firstMonth", 1320, "secondMonth", 90, "thirdMonth", 200);
		Map<String, Integer> result = customerRewardServiceImpl.calculateRewardsPoints(rewards);
     	assertNotNull(result);
		assertEquals(2490, result.get("firstMonth"));
		assertEquals(40, result.get("secondMonth"));
		assertEquals(250, result.get("thirdMonth"));
	}

	@Test
	void testTransaction() {
		assertEquals(2490, customerRewardServiceImpl.transaction(1320));  
		assertEquals(40, customerRewardServiceImpl.transaction(90));      
		assertEquals(250, customerRewardServiceImpl.transaction(200));    
	}
}
