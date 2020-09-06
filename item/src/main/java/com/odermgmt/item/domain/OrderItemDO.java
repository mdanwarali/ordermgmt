package com.odermgmt.item.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Table(name="orderitem")
@Entity
@Setter
@Getter
public class OrderItemDO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productItemId;
	
	@NotBlank(message = "orderNo is mandatory")
	private String orderNo;
	
	@NotBlank(message = "itemCode is mandatory")
	private String itemCode;
	
	@NotBlank(message = "itemName is mandatory")
	private String itemName;
	
	@NotNull(message = "itemQuantity is mandatory")
	@Min(value =5 , message="minimum mandatory is 1")
	private Integer itemQuantity;

	public Long getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(Long productItemId) {
		this.productItemId = productItemId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
}
