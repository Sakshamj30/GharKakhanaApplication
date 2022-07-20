package com.capgemini.gharkakhanaapi.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long orderId;
	public String orderStatus;
	@JsonFormat(pattern="yyy-MM-dd")
	private Date order_At;
	@JsonFormat(pattern="yyy-MM-dd")
	private Date updated_At;
	public Order() {
		super();
	}
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "orderId")
	private List<Food> foods;
	
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}	

	@PrePersist
	public void onOrder() {
		this.setOrder_At(new Date());
	}

	@PreUpdate
	public void onUpdate() {
		this.setUpdated_At(new Date());
	}



	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Date getOrder_At() {
		return order_At;
	}

	public void setOrder_At(Date order_At) {
		this.order_At = order_At;
	}
}
