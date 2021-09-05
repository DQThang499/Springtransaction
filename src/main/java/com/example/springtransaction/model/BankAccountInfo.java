package com.example.springtransaction.model;

public class BankAccountInfo {
	// chứa tổng hợp những thông tin liên quan đến tblae giống file DTO KL 
	// được khai báo và xử lý tầng front-end
	
	private Long id;
	private String full_Name;
	private double balance;
	
	public BankAccountInfo() {
		
	}
	// Sử dụng trong truy vấn JPA
	public BankAccountInfo(Long id, String full_name, double balance) {
		this.id = id;
		this.full_Name = full_name;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFull_Name() {
		return full_Name;
	}
	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
