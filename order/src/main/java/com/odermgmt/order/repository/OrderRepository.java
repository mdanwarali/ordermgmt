package com.odermgmt.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odermgmt.order.domain.OrderDO;

public interface OrderRepository extends JpaRepository<OrderDO, Long> {
	
}
