import java.util.concurrent.atomic.AtomicLong;

public class Account {

    private AtomicLong money = new AtomicLong();
    private String accNumber;
    private volatile boolean blocked;

    public Account() {
    }

    public Account(long money, String accNumber) {
        this.money.set(money);
        this.accNumber = accNumber;
        this.blocked = false;
    }

    public long getMoney() {
        return money.get();
    }

    public synchronized void setMoney(long money) {
        this.money.set(money);
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void block() {
        this.blocked = true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
