import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Map<String, Account> accounts = new HashMap<>();
        Account account = new Account(200000, "123");
        Account account1 = new Account(200000, "321");
        accounts.put(account.getAccNumber(), account);
        accounts.put(account1.getAccNumber(), account1);
        bank.setAccounts(accounts);

        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                try {
                    bank.transfer(account1.getAccNumber(), account.getAccNumber(), 10_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            new Thread(() -> {
                try {
                    bank.transfer(account1.getAccNumber(), account.getAccNumber(), 5_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            new Thread(() -> {
                try {
                    bank.transfer(account.getAccNumber(), account1.getAccNumber(), 15_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
