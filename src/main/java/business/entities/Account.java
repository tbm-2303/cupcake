package business.entities;

public class Account {

private int konto_id;
private int balance;

    public Account(int balance) {

        this.balance = balance;
    }

    public int getKonto_id() {
        return konto_id;
    }

    public void setKonto_id(int konto_id) {
        this.konto_id = konto_id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
