package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных счета в банке
 * @author RELAXA
 * @version 1.0
 */
public class Account {
    /**
     * реквизиты счета
     */
    private String requisite;
    /**
     * баланс счета
     */
    private double balance;

    /**
     * Конструктор класса, инициализирует счет с заданными реквизитами и балансом.
     * @param requisite реквизит счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод получает реквизиты счета.
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавлиает новые реквизиты счета.
     * @param requisite новые реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод получает баланс счета.
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает новый баланс счета.
     * @param balance новый баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals() для сравнения счетов на основе реквизитов.
     * @param object объект для сравнения
     * @return true, если счета равны, false в противном случае
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Account account = (Account) object;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode() для генерации хэш-кода на основе реквизитов.
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
