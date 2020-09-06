package com.odermgmt.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odermgmt.order.domain.OrderDO;
import com.odermgmt.order.dto.Order;
import com.odermgmt.order.service.OrderService;

@RestController
@RequestMapping (value="/order", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createOrder(@RequestBody Order order) {
		return ResponseEntity.ok(orderService.createOrder(order));
	}
	
	@GetMapping("/find/{orderid}")
	public ResponseEntity<Order> getOrder(@PathVariable("orderid") Long orderid) {
		return ResponseEntity.ok(orderService.getOrderById(orderid));
	}
	
	
}
