package Account;
import java.util.UUID;

public class Account implements Comparable<Account> {
    private String id;
    private long balance;

    public Account(int balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public void addToBalance(long value) throws Exception {
        long balance = this.balance;
        this.balance = balance + value;
    }


    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }

    public int compareTo(Account account) {
        return Long.compare(balance, account.balance);
    }
}
