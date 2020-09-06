package com.odermgmt.item.controller;

import java.util.Collection;

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

import com.odermgmt.item.domain.OrderItemDO;
import com.odermgmt.item.service.OrderItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/item")
public class OrderItemController {

	@Autowired
	OrderItemService itemService;
	
	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addItem(@RequestBody OrderItemDO item) {
		itemService.createOrderItem(item);
		return ResponseEntity.ok("Item added successfully");
	}
	
	@GetMapping("/find/{orderNo}")
	public ResponseEntity<Collection<OrderItemDO>> getOrderItem(@Valid @PathVariable String orderNo) {
		return ResponseEntity.ok(itemService.getOrderItems(orderNo));
	}
}
