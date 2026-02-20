package com.aracnideo.model;

public class Account {

	private int id;
	private String ownerName;
	private double balance;

	public Account(int id, String ownerName, double balance) {
		if (id < 0) {
			throw new IllegalArgumentException("Invalid id.");
		}
		if (ownerName == null) {
			throw new IllegalArgumentException("Invalid Onwer Name.");
		}
		if (balance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative.");
		}
		this.id = id;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}

	public void deposit(double value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Deposit value must be greater than zero.");
		}
		this.balance += value;
	}

	public void withdraw(double value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Withdraw value must be greater than zero.");
		}
		if (value > this.balance) {
			throw new IllegalArgumentException("Insuficient balance.");
		}
		this.balance -= value;
	}

}
