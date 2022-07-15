package com.capgemini.gharkakhana.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long foodId;
	
	@NotBlank(message = "foodIdentifier Required")
	@Size(min=3, max=10, message = "invalid foodIdentifier")
	@Column(updatable = false, unique = true)
	private String foodIdentifier;
	
	@NotBlank(message = "foodName is required")
	private String foodName;
	
	@NotBlank(message = "foodDescription is required")
	private String foodDescription;
	
	@NotBlank(message = "foodStatus is required")
	private String foodStatus;
	
	private Date order_date;
	
	private Date created_At;
	private Date updated_At;
	
	
	public Food() {
		super();
	}
	
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	
	public String getFoodIdentifier() {
		return foodIdentifier;
	}

	public void setFoodIdentifier(String foodIdentifier) {
		this.foodIdentifier = foodIdentifier;
	}

	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodDescription() {
		return foodDescription;
	}
	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	public String getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Date getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	public Date getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	@PrePersist
	public void onCreate() {
		this.created_At = new Date();
		}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}
	

}
