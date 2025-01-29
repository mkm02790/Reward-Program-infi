package com.reward.customerReward.exception;


import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.reward.customerReward.controller.CustomerRewardController;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerRewardController.class);
	
	@ExceptionHandler(InvalidCustomerRequestException.class)
	public ResponseEntity<String> handlerInvalidCustomerRequestException(InvalidCustomerRequestException res) {
		logger.info("handlerInvalidCustomerRequestException logging lavel");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidProcessedResponse.class)
	public ResponseEntity<String> handlerInvalidProcessedResponse(InvalidCustomerRequestException res) {
		logger.info("handlerInvalidProcessedResponse logging lavel");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
