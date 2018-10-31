package com.nbs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbs.pojo.Item;
import com.nbs.pojo.Order;
import com.nbs.pojo.OrderDetail;

@Service
public class OrderService {

	private static final Map<String, Order> MAP = new HashMap<String, Order>();
	
	static {
		Order order = new Order();
		order.setOrderId("59193738268961441");
		order.setCreateDate(new Date());
		order.setUpdateDate(order.getCreateDate());
		order.setUserId(1L);
		
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		
		Item item = new Item();
		item.setId(1L);
		orderDetails.add(new OrderDetail(order.getOrderId(), item));
		
		item = new Item();
		item.setId(2L);
		orderDetails.add(new OrderDetail(order.getOrderId(), item));
		
		order.setOrderDetails(orderDetails);
		
		MAP.put(order.getOrderId(), order);
		
		
	}
	
	@Autowired
	private ItemService itemService;
	
	public Order queryOrderById(String orderId) {
		Order order = MAP.get(orderId);
		
		List<OrderDetail> orderDetails = order.getOrderDetails();
		for(OrderDetail orderDetail : orderDetails){
			Long id = orderDetail.getItem().getId();
			Item item = itemService.queryItemById(id);
			orderDetail.setItem(item);
		}
		
		return order;
	}

}
