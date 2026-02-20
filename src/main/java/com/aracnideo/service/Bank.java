package com.aracnideo.service;

import java.util.ArrayList;
import java.util.List;

import com.aracnideo.model.Account;
import com.aracnideo.model.Transaction;
import com.aracnideo.model.TransactionType;

public class Bank {

	private List<Account> accounts;
	private List<Transaction> transactions;

	public Bank() {
		this.accounts = new ArrayList<Account>();
		this.transactions = new ArrayList<Transaction>();
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + ", transactions=" + transactions + "]";
	}

	public void addAccount(Account account) {
		if (account == null) {
			throw new IllegalArgumentException("Account cannot be null.");
		}
		this.accounts.add(account);
	}

	public void processTransaction(Account account, TransactionType type, double value) {
		Transaction transaction = new Transaction(account, type, value);
		this.transactions.add(transaction);
	}

}
