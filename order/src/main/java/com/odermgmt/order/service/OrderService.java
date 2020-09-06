package com.odermgmt.order.service;

import com.odermgmt.order.dto.Order;

public interface OrderService {
	public Long createOrder(Order order);
	public Order getOrderById(Long id);
}
