package com.reward.customerReward.customerRewardControllerTest;

import com.reward.customerReward.controller.CustomerRewardController;
import com.reward.customerReward.entity.Customer;
import com.reward.customerReward.entity.RewardResponse;
import com.reward.customerReward.exception.InvalidCustomerRequestException;
import com.reward.customerReward.exception.InvalidProcessedResponse;
import com.reward.customerReward.service.CustomerRewardServiceInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerRewardControllerTest {

	@InjectMocks
	private CustomerRewardController customerRewardController;

	@Mock
	private CustomerRewardServiceInt customerRewardServiceInt;

	@Mock
	private RewardResponse rewardResponse;

	private Customer customer;

	@BeforeEach
	void setUp() {
		customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("John Doe");
		customer.setRewards(Map.of("firstMonth", 150, "secondMonth", 75, "thirdMonth", 125));
	}

	@Test
	void testCalCulateCustomerReward_Success() throws InvalidProcessedResponse, InvalidCustomerRequestException {
		when(customerRewardServiceInt.processTransaction(customer)).thenReturn(rewardResponse);

		ResponseEntity<RewardResponse> response = customerRewardController.calCulateCustomerReward(customer);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(rewardResponse, response.getBody());
		verify(customerRewardServiceInt, times(1)).processTransaction(customer);
	}

	@Test
	void testCalCulateCustomerReward_NullCustomer() {
		Customer nullCustomer = null;
		assertThrows(InvalidCustomerRequestException.class, () -> {
			customerRewardController.calCulateCustomerReward(nullCustomer);
		});
	}

	@Test
	void testCalCulateCustomerReward_NullRewardResponse()
			throws InvalidProcessedResponse, InvalidCustomerRequestException {
		when(customerRewardServiceInt.processTransaction(customer)).thenReturn(null);
		assertThrows(InvalidProcessedResponse.class, () -> {
			customerRewardController.calCulateCustomerReward(customer);
		});
	}
}
