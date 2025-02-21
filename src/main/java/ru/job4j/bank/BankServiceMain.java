package ru.job4j.bank;

import java.util.Optional;

public class BankServiceMain {
    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> optional = bank.findByPassport("3211");
        optional.ifPresent(user -> System.out.println(user.getUsername()));
    }
}
