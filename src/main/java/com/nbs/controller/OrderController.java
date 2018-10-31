package com.nbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nbs.pojo.Order;
import com.nbs.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/order/{orderId}")
	public Order queryOrderById(@PathVariable (name = "orderId") String orderId) {
		return this.orderService.queryOrderById(orderId);
	}

	

}
