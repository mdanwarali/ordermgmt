package com.odermgmt.order.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.odermgmt.order.controller.ItemFeignClientProxy;
import com.odermgmt.order.domain.OrderDO;
import com.odermgmt.order.dto.Item;
import com.odermgmt.order.dto.Order;
import com.odermgmt.order.repository.OrderRepository;
import com.ordermgmt.exceptions.OrderNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ItemFeignClientProxy itemFeignProxy;
	
	@Override
	public Long createOrder(Order order) {
		OrderDO orderDO = new OrderDO();
		try {
			PropertyUtils.copyProperties(orderDO, order);
			repository.save(orderDO);
			order.getItemList().forEach(item -> {
				item.setOrderNo(orderDO.getOrderid());
				itemFeignProxy.addItem(item);
			});
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderDO.getOrderid();
	}

	@Override
	public Order getOrderById(Long id) {
		Optional<OrderDO> orderDO = repository.findById(id);
		if(orderDO.get() == null)
			throw new OrderNotFoundException("Order["+ id +"] not found ");
		
		Order order = new Order();
		ResponseEntity<Collection<Item>> response = itemFeignProxy.getOrderItem(id);
		try {
			PropertyUtils.copyProperties(order, orderDO.get());
			order.setItemList(response.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}

}
