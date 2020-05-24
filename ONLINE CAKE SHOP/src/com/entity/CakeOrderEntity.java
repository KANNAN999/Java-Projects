package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CakeOrderEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer OrderId;
	private String customerName;
	private String contactNumber;
	private Integer cakeID;
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
