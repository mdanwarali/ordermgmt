package com.odermgmt.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.odermgmt.item.domain.OrderItemDO;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemDO, Long> {
	
	@Query("SELECT item FROM OrderItemDO item where item.orderNo = :orderNo") 
	public List<OrderItemDO> findItemByOrderNo(@Param("orderNo")String orderNo); 
}
