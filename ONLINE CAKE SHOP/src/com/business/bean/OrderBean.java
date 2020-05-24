package com.business.bean;

import javax.validation.constraints.NotNull;

public class OrderBean {

	@NotNull(message="Order Id Cannot be Empty")
	private Integer OrderId;

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	
}
