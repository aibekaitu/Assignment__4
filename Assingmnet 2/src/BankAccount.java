public class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
    public void deposit(double amount){
        balance=balance+amount;
    }
    public boolean withdraw(double amount){
        if (amount > balance){
            return false;
        }
        balance=balance-amount;
        return true;
    }
}