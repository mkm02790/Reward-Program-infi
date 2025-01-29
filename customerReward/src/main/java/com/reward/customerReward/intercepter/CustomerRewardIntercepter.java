package com.reward.customerReward.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.reward.customerReward.controller.CustomerRewardController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerRewardIntercepter implements HandlerInterceptor {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomerRewardController.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Excution of prehandle method of Intercepter");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("Excution of postHandle method of Intercepter");
			}

}
