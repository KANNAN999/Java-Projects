package com.business.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BillRangeBean {

	@NotNull(message="From Price Cannot be Empty")
	@Min(value=1,message="Minimum value Should be 1")
	private Double fromPrice;
	@NotNull(message="From Price Cannot be Empty")
	@Min(value=600,message="Minimum Cake Price starts from Rs 600")
	private Double toPrice;
	public Double getFromPrice() {
		return fromPrice;
	}
	public void setFromPrice(Double fromPrice) {
		this.fromPrice = fromPrice;
	}
	public Double getToPrice() {
		return toPrice;
	}
	public void setToPrice(Double toPrice) {
		this.toPrice = toPrice;
	}
	
}
