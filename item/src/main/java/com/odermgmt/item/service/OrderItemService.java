package com.odermgmt.item.service;

import java.util.Collection;

import com.odermgmt.item.domain.OrderItemDO;

public interface OrderItemService {

	/**
	 * @param order
	 * @return
	 */
	public OrderItemDO createOrderItem(OrderItemDO order);
	
	/**
	 * @param orderNo
	 * @return
	 */
	public Collection<OrderItemDO> getOrderItems(String orderNo);
}
