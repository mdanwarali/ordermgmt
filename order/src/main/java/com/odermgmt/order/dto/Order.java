package com.odermgmt.order.dto;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
	
	private Long orderid;
	
	@NotBlank
	private String customerName;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date orderDate;
	
	@NotBlank
	private String shipingAddress;
	
	@NotNull
	@Min(1)
	private Integer total;
	
	@NotBlank
	private Collection<Item> itemList;


	public Long getOrderid() {
		return orderid;
	}


	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getShipingAddress() {
		return shipingAddress;
	}


	public void setShipingAddress(String shipingAddress) {
		this.shipingAddress = shipingAddress;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public Collection<Item> getItemList() {
		return itemList;
	}


	public void setItemList(Collection<Item> itemList) {
		this.itemList = itemList;
	}
}
