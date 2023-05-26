//import junit.framework.TestCase;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class BankTest extends TestCase {
//
//    private Map<String, Account> accounts = new HashMap<>();
//    private Map<String, Account> accounts1 = new HashMap<>();
//    Bank bank = new Bank();
//
//    @Override
//    protected void setUp() throws Exception {
//        for (int i = 0; i < 1000; i++) {
//            accounts.put(String.valueOf(i), new Account((long) (Math.random() * 60_000), "№" + (Math.random() * 60_000)));
//        }
//        accounts1.put("123", new Account(60000, "123"));
//        accounts1.put("321", new Account(60000, "321"));
//    }
//
//    public void testTransfer() {
//        List<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            threads.add(new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    try {
//                        bank.transfer("№" + ((int) (Math.random() * 1_000)), "№" + (int) (Math.random() * 1_000),
//                                (int) (Math.random() * 60_000));
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }));
//        }
//    }
//
//    public void testGetBalance() {
//        try {
//            bank.transfer("123", "321", 5000);
//            long money = bank.getBalance(accounts1.get("123").getAccNumber());
//            assertEquals(money, 55000);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BankTest extends TestCase {

    private Bank bank;

    @Before
    public void setUp() {

        bank = new Bank();
    }

    @Test
    public void testTransferIsBlock() throws InterruptedException {

        Account account = new Account();
        Account account1 = new Account();

        account.setMoney(600_000);
        account1.setMoney(600_000);

        do {
            new Thread(() -> {
                try {
                    bank.transfer(account.getAccNumber(), account1.getAccNumber(), 55_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            Thread.sleep(500);
        } while (account.isBlocked());
    }

    @Test
    public void testTransfer() throws InterruptedException {

        Account account = new Account(200000, "123");
        Account account1 = new Account(200000, "321");

        Map<String, Account> accounts = new HashMap<>();
        accounts.put(account.getAccNumber(), account);
        accounts.put(account1.getAccNumber(), account1);

        bank.setAccounts(accounts);

        for (int i = 0; i < 10; i++) {
            bank.transfer(account1.getAccNumber(), account.getAccNumber(), 10_000);
        }

        long money = bank.getBalance(account.getAccNumber());
        assertEquals(money, 300_000);
    }

    @Test
    public void testGetBalanse() {
        Account account = new Account(200000, "321");
        Map<String, Account> accounts = new HashMap<>();
        accounts.put(account.getAccNumber(), account);
        bank.setAccounts(accounts);

        long money = bank.getBalance(account.getAccNumber());
        assertEquals(money, 200_000);
    }

    @Test
    public void testGetSumAllAccounts() {
        Account account = new Account(200000, "123");
        Account account1 = new Account(200000, "321");

        Map<String, Account> accounts = new HashMap<>();
        accounts.put(account.getAccNumber(), account);
        accounts.put(account1.getAccNumber(), account1);

        bank.setAccounts(accounts);
        long money = bank.getSumAllAccounts();
        assertEquals(money, 400_000);
    }
}