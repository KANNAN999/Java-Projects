package com.business.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CakeOrderBean {

	
	private Integer OrderId;
	@NotEmpty(message="Customer Name Cannot be Empty")
	private String customerName;
	@NotEmpty(message="Contact Number Cannot be Empty")
	@Min(value=10,message="Contact Number Invalid")
	@Max(value=10,message="Contact Number Invalid")
	private String contactNumber;
	@NotNull(message="Please select a Cake")
	private Integer cakeID;
	@NotNull(message="Quantity cannot be Empty")
	@Min(value=1,message="Quantity should be atleast 1")
	private Integer noOfPiecesOrdered;
	private Double bill;
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Integer getCakeID() {
		return cakeID;
	}
	public void setCakeID(Integer cakeID) {
		this.cakeID = cakeID;
	}
	public Integer getNoOfPiecesOrdered() {
		return noOfPiecesOrdered;
	}
	public void setNoOfPiecesOrdered(Integer noOfPiecesOrdered) {
		this.noOfPiecesOrdered = noOfPiecesOrdered;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	
}
