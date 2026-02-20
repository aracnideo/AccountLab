import com.aracnideo.model.Account;
import com.aracnideo.model.TransactionType;
import com.aracnideo.service.Bank;

public class Main {

	public static void main(String[] args) {

		Bank bank = new Bank();
		Account account = new Account(1, "Adam West", 0.0);
		bank.addAccount(account);

		System.out.println("\t~~Initial Status~~");
		System.out.println(account);

		bank.processTransaction(account, TransactionType.DEPOSIT, 500);

		System.out.println("\n\t~~After Deposit~~");
		System.out.println(account);

		bank.processTransaction(account, TransactionType.WITHDRAW, 200);

		System.out.println("\n\t~~After Withdraw~~");
		System.out.println(account);

		try {
			bank.processTransaction(account, TransactionType.WITHDRAW, 1000);
		} catch (Exception e) {
			System.out.println("\nExpected error: " + e.getMessage());
		}

		System.out.println("\n\t~~Final Status~~");
		System.out.println(account);

		System.out.println("\n\t~~Transaction History~~");
		System.out.println(bank.getTransactions());
	}

}
