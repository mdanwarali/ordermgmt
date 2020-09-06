package com.odermgmt.item.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odermgmt.item.domain.OrderItemDO;
import com.odermgmt.item.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository repository;

	@Override
	public OrderItemDO createOrderItem(OrderItemDO order) {
		return repository.save(order);
	}

	@Override
	public Collection<OrderItemDO> getOrderItems(String orderNo) {
		return repository.findItemByOrderNo(orderNo);
	}
}
