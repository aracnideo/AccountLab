package com.aracnideo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

	private final int accountId;
	private final TransactionType type;
	private final double value;
	private final double balanceBefore;
	private final double balanceAfter;
	private final LocalDateTime timestamp;

	public Transaction(Account account, TransactionType type, double value) {
		if (account == null) {
			throw new IllegalArgumentException("Account cannot be null.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Transaction type cannot be null.");
		}
		if (value <= 0) {
			throw new IllegalArgumentException("Transaction value must be greater than zero.");
		}
		this.accountId = account.getId();
		this.type = type;
		this.value = value;
		this.balanceBefore = account.getBalance();

		if (type == TransactionType.DEPOSIT) {
			account.deposit(value);
		} else {
			account.withdraw(value);
		}

		this.balanceAfter = account.getBalance();
		this.timestamp = LocalDateTime.now().withNano(0);
	}

	public int getAccountId() {
		return accountId;
	}

	public TransactionType getType() {
		return type;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return "\nTransaction [accountId=" + accountId + ", type=" + type + ", value=" + value + ", balanceBefore="
				+ balanceBefore + ", balanceAfter=" + balanceAfter + ", timestamp=" + timestamp.format(formatter) + "]";
	}

}
