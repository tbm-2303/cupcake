package business.entities;

public class Account {

private int konto_id;
private double balance;

    public Account(double balance) {

        this.balance = balance;
    }

    public int getKonto_id() {
        return konto_id;
    }

    public void setKonto_id(int konto_id) {
        this.konto_id = konto_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
