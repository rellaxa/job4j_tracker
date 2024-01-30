package ru.job4j.encapsulation;

public class ATM {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("number - 0509-43-7624356", 455000);
        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());

        System.out.println();
        account.deposit(780000);
        System.out.println(account.getBalance());

        System.out.println();
        account.withdraw(346000);
        System.out.println(account.getBalance());
    }
}
