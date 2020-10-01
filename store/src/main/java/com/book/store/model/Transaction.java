package com.book.store.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="user_phone")
	private String user_phone;
	
	@Column(name="user_address")
	private String user_address;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="payment_info")
	private String payment_info;
	
	@Column(name="message")
	private String message;
	
	@Column(name="security")
	private String security;
	
	@Column(name="created")
	private LocalDate created;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPayment_info() {
		return payment_info;
	}

	public void setPayment_info(String payment_info) {
		this.payment_info = payment_info;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}
	
	
}
