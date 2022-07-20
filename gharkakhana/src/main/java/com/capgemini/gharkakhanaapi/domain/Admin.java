package com.capgemini.gharkakhanaapi.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AdminId;
	@NotBlank(message = "Please enter your OrderId")
	private String OrderId;
	@NotBlank(message = "Please enter mobile number")
	 @Size(min = 10, max=10, message = "Please Enter Correct Mobile Number")
	    @Column(updatable = false, unique = true)
	private String mobileNumber;
	@JsonFormat(pattern="yyy-MM-dd")
	private Date created_At;
	@JsonFormat(pattern="yyy-MM-dd")
	private Date updated_At;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Vendor Vendor;
	
	public Long getAdminId() {
		return AdminId;
	}

	public void setAdminId(Long adminId) {
		this.AdminId = adminId;
	}

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		this.OrderId = orderId;
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

	public Vendor getVendor() {
		return Vendor;
	}

	public void setVendor(Vendor vendor) {
		this.Vendor = vendor;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
