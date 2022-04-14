package com.example.retail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.retail.services.RetailServices;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Pid;
	
	private String name;
	private String type;
	private String category;
	private Long price;
	private Long userId;
	
	
	public Product(Long pid, String name, String type, String category, Long price, Long userId) {
		super();
		Pid = pid;
		this.name = name;
		this.type = type;
		this.category = category;
		this.price = price;
		this.userId = userId;
	}	
	
	public Product(Product param, RetailServices retailServices) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Long getPid() {
		return Pid;
	}
	public void setPid(Long pid) {
		Pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", name=" + name + ", type=" + type + ", category=" + category + ", price="
				+ price + ", userId=" + userId + "]";
	}

	
}
