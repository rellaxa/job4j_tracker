package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * @author RELAXA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в карте типа HashMap
     * Ключ — объект User, значение — список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет в карту
     * Если пользователь уже существует в карте, то этот пользователь
     * добавлен не будет
     * @param user пользователь, который добавляется в карту
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимет на вход номер паспорта пользователя и
     * удаляет пользователя из карты
     * @param passport паспорт, по которому удаляется пользователь
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход номер паспорта и счет в банке пользователя,
     * находит пользователя по паспорту, если пользователь существует,
     * то метод получает список счетов пользователя и добавляет
     * новый счет к ним, если такого счета у пользователя нет
     * @param passport пасорт, по которому ищется пользователь
     * @param account счет в банке, который добавляется в список счетов пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспорта пользователя и
     * ищет пользователя в карте.
     * @param passport пасорт, по которому ищется пользователь
     * @return возвращает найденного пользователя или null, если пользователя нет
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> result = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = Optional.of(user);
                break;
            }
        }
        return result;
    }

    /**
     * Метод принимает на вход номер паспорта и реквизиты пользователя,
     * находит пользователя по паспорту, если пользователь существует,
     * находит список счетов пользозователя по ключу в карте и возвращает
     * счет по реквизитам счета, если такой счет существует
     * @param passport номер паспорта, по которому ищется пользователь
     * @param requisite реквизиты, по которым ищется счет
     * @return возвращает счет или null, если пользователь или счет не найдены
     */
    public Account findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            for (Account account : users.get(user.get())) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт и реквизиты отправителя,
     * паспорт и реквизиты получателя, и сумму перевода.
     * Находит счета этих пользователей по паспортам и реквизитам. Если счета сущетсвуют,то
     * списывается сумма со счета отправителя, если на счете достаточно средств, и
     * начисляется на счет получателя
     * @param sourcePassport номер паспорта отправителя
     * @param sourceRequisite реквзиты, отправителя
     * @param destinationPassport номер паспорта получателя
     * @param destinationRequisite реквизиты получателя
     * @param amount сумма для перевода
     * @return возвращает true, если перевод произведен
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAcc = findByRequisite(sourcePassport, sourceRequisite);
        Account dstAcc = findByRequisite(destinationPassport, destinationRequisite);
        if (srcAcc != null
                && dstAcc != null
                && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            dstAcc.setBalance(dstAcc.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод принимает на вход пользователя
     * и возвращает список его счетов
     * @param user пользователь, счета которого находят
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
