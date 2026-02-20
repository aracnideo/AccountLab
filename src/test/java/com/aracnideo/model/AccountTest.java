package com.aracnideo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void constructorShouldSetInitialValuesCorrectly() {
		Account account = new Account(1, "Test", 500.0);

		assertEquals(1, account.getId());
		assertEquals("Test", account.getOwnerName());
		assertEquals(500.0, account.getBalance());
	}

	@Test
	void constructorShouldThrowWhenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> new Account(1, null, 0.0));
	}

	@Test
	void constructorShouldThrowWhenNameIsBlank() {
		assertThrows(IllegalArgumentException.class, () -> new Account(1, "   ", 0.0));
	}

	@Test
	void depositShouldIncreaseBalance() {
		Account account = new Account(1, "Test", 0.0);

		account.deposit(100);

		assertEquals(100.0, account.getBalance());
	}

	@Test
	void depositShouldThrowWhenValueIsZero() {
		Account account = new Account(1, "Test", 0.0);

		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(0);
		});
	}

	@Test
	void depositShouldThrowWhenValueIsNegative() {
		Account account = new Account(1, "Test", 0.0);

		assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(-10);
		});
	}

	@Test
	void withdrawShouldDecreaseBalance() {
		Account account = new Account(1, "Test", 200.0);

		account.withdraw(50);

		assertEquals(150.0, account.getBalance());
	}

	@Test
	void withdrawShouldThrowWhenValueIsZero() {
		Account account = new Account(1, "Test", 100.0);

		assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(0);
		});
	}

	@Test
	void withdrawShouldThrowWhenValueIsNegative() {
		Account account = new Account(1, "Test", 100.0);

		assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(-50);
		});
	}

	@Test
	void withdrawShouldThrowWhenInsufficientBalance() {
		Account account = new Account(1, "Test", 100.0);

		assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(200);
		});
	}

	@Test
	void withdrawShouldAllowZeroBalance() {
		Account account = new Account(1, "Test", 100.0);

		account.withdraw(100);

		assertEquals(0.0, account.getBalance());
	}

	@Test
	void multipleOperationsShouldMaintainCorrectBalance() {
		Account account = new Account(1, "Test", 0.0);

		account.deposit(200);
		account.withdraw(50);
		account.deposit(25);

		assertEquals(175.0, account.getBalance());
	}

}
