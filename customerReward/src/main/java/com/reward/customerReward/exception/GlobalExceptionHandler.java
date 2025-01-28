package com.reward.customerReward.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidCustomerRequestException.class)
	public ResponseEntity<String> handlerInvalidCustomerRequestException(InvalidCustomerRequestException res) {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidProcessedResponse.class)
	public ResponseEntity<String> handlerInvalidProcessedResponse(InvalidCustomerRequestException res) {

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
