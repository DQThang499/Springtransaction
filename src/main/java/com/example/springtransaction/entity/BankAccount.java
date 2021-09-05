package com.example.springtransaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// chỉ chứa thông tin từ table sang giống File không DTO giống với DB
@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "full_name", nullable = false)
	private String full_name;
	@Column(name = "BALANCE", nullable = false)
	private double BALANCE;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public double getBALANCE() {
		return BALANCE;
	}

	public void setBALANCE(double bALANCE) {
		BALANCE = bALANCE;
	}
	
	
}
