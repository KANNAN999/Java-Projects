package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cake")
public class CakeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cakeId;
	private String cakeName;
	private Double price;
	public Integer getCakeId() {
		return cakeId;
	}
	public void setCakeId(Integer cakeId) {
		this.cakeId = cakeId;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
