package ru.job4j.encapsulation;

public class BankAccount {
    private String accountNumber;
    private int balance;

    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        if (money > 0) {
            balance += money;
        }
    }

    public void withdraw(int money) {
        if (money > 0 && money <= balance) {
            balance -= money;
        }
    }
}
