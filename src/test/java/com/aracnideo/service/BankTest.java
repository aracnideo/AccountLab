package com.aracnideo.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.aracnideo.model.Account;
import com.aracnideo.model.TransactionType;

public class BankTest {

	@Test
	void shouldStartEmpty() {
		Bank bank = new Bank();
		assertTrue(bank.getAccounts().isEmpty());
		assertTrue(bank.getTransactions().isEmpty());
	}

	@Test
	void shouldAddAccount() {
		Bank bank = new Bank();
		Account account = new Account(44, "Indianara", 800);
		bank.addAccount(account);
		assertEquals(1, bank.getAccounts().size());
		assertTrue(bank.getAccounts().contains(account));
	}

	@Test
	void shouldThrowExceptionWhenAccountIsNull() {
		Bank bank = new Bank();
		assertThrows(IllegalArgumentException.class, () -> bank.addAccount(null));
	}

	@Test
	void shouldProcessDeposit() {
		Bank bank = new Bank();
		Account account = new Account(48, "Jessica", 1900);
		bank.addAccount(account);
		bank.processTransaction(account, TransactionType.DEPOSIT, 700);
		assertEquals(2600, account.getBalance());
		assertEquals(1, bank.getTransactions().size());
	}

	@Test
	void shouldProcessWithdraw() {
		Bank bank = new Bank();
		Account account = new Account(49, "Kleito", 340);
		bank.addAccount(account);
		bank.processTransaction(account, TransactionType.WITHDRAW, 150);
		assertEquals(190, account.getBalance());
		assertEquals(1, bank.getTransactions().size());
	}

	@Test
	void shouldNotAddTransactionIfWithdrawFails() {
		Bank bank = new Bank();
		Account account = new Account(50, "Laica", 4000);
		bank.addAccount(account);
		assertThrows(IllegalStateException.class,
				() -> bank.processTransaction(account, TransactionType.WITHDRAW, 5000));
		assertTrue(bank.getTransactions().isEmpty());
		assertEquals(4000, account.getBalance());
	}

	@Test
	void shouldNotProcessTransactionForNonRegisteredAccount() {
		Bank bank = new Bank();
		Account account = new Account(79, "Milton", 1530);
		assertThrows(IllegalArgumentException.class,
				() -> bank.processTransaction(account, TransactionType.WITHDRAW, 150));
	}

}
