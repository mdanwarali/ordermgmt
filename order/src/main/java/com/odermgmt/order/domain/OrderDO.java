package com.odermgmt.order.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="myorder")
@Entity
public class OrderDO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
}
