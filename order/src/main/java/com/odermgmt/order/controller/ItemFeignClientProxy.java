package com.odermgmt.order.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.odermgmt.order.dto.Item;
import com.odermgmt.order.dto.Order;


@FeignClient(name="item-feign", url="http://localhost:8081")
public interface ItemFeignClientProxy {
	
	@PostMapping(value="item/add", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addItem(@RequestBody Item item);
	
	@GetMapping("item/find/{orderNo}")
	public ResponseEntity<Collection<Item>> getOrderItem(@Valid @PathVariable Long orderNo);
}
