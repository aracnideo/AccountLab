package com.aracnideo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TransactionTest {

	@Test
	void shouldThrowExceptionWhenAccountIsNull() {
		assertThrows(IllegalArgumentException.class, () -> new Transaction(null, TransactionType.DEPOSIT, 100));
	}

	@Test
	void shouldThrowExceptionWhenTypeIsNull() {
		Account account = new Account(5, "Adam", 10);
		assertThrows(IllegalArgumentException.class, () -> new Transaction(account, null, 50));
	}

	@Test
	void shouldThrowExceptionWhenDepositValueIsZero() {
		Account account = new Account(12, "Beto", 50);
		assertThrows(IllegalArgumentException.class, () -> new Transaction(account, TransactionType.DEPOSIT, 0));
	}

	@Test
	void shouldThrowExceptionWhenDepositIsNegative() {
		Account account = new Account(16, "Carlos", 15);
		assertThrows(IllegalArgumentException.class, () -> new Transaction(account, TransactionType.DEPOSIT, -10));
	}

	@Test
	void shouldResolveDepositTransactionCorrectly() {
		Account account = new Account(18, "Durgal", 3250);
		Transaction transaction = new Transaction(account, TransactionType.DEPOSIT, 750);
		assertEquals(4000, account.getBalance());
		assertEquals(TransactionType.DEPOSIT, transaction.getType());
		assertEquals(750, transaction.getValue());
	}

	@Test
	void shouldResolveWithdrawTransactionCorrectly() {
		Account account = new Account(27, "Edimundo", 500);
		Transaction transaction = new Transaction(account, TransactionType.WITHDRAW, 288);
		assertEquals(212, account.getBalance());
		assertEquals(TransactionType.WITHDRAW, transaction.getType());
		assertEquals(288, transaction.getValue());
	}

	@Test
	void shouldStoreBalanceBeforeAndAfterCorrectly() {
		Account account = new Account(30, "Fabrizio", 650);
		Transaction transaction = new Transaction(account, TransactionType.DEPOSIT, 500);
		assertEquals(650, transaction.getBalanceBefore());
		assertEquals(1150, transaction.getBalanceAfter());
	}
}
