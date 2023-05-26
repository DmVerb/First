import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Bank() {
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Random getRandom() {
        return random;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        if (fromAccountNum.equals(toAccountNum)) {
            return;
        }

        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        if (!fromAccount.isBlocked() || !toAccount.isBlocked()) {
            if (fromAccount.getMoney() < amount) {
                System.out.println("Not money: account # " + fromAccount.getAccNumber());
            }
            if (amount > 0 & amount <= 50000) {
                if (fromAccount.getMoney() >= amount) {
                    synchronized (toAccount) {
                        synchronized (fromAccount) {
                            fromAccount.setMoney(fromAccount.getMoney() - amount);
                            toAccount.setMoney(toAccount.getMoney() + amount);
                            System.out.println("Transfer complete" + "\n" + fromAccount.getAccNumber() + "\t" + fromAccount.getMoney()
                                    + "\n" + toAccount.getAccNumber() + "\t" + toAccount.getMoney());
                        }
                    }
                }
            }
            if (amount > 50000) {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    synchronized (toAccount) {
                        synchronized (fromAccount) {
                            fromAccount.setMoney(fromAccount.getMoney() - amount);
                            toAccount.setMoney(toAccount.getMoney() + amount);
                            System.out.println("Transfer complete" + "\n" + fromAccount.getAccNumber()
                                    + "\n" + toAccount.getAccNumber());
                        }
                    }
                } else {
                    fromAccount.block();
                    toAccount.block();
                    System.out.println("All accounts was blocked");
                }
            }
        } else {
            System.out.println("Accounts is block!");
        }
    }


    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);

        if (account == null) {
            throw new IllegalArgumentException("Неверный номер счета");
        }
        synchronized (account) {
            return account.getMoney();
        }
    }

    public long getSumAllAccounts() {
        AtomicLong all = new AtomicLong();
        accounts.forEach((k, v) -> all.addAndGet(v.getMoney()));
        return all.get();
    }
}
