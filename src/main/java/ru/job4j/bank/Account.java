package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает работу объект счёта пользователя
 * @author YAROSLAV ABATUROV
 * @version 1.0
 */

public class Account {
    /**
     * Значение реквизита
     */
    private String requisite;

    /**
     * Значение баланса
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттеры и сеттеры полей класса
     */
    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределяем методы hashCode() и equals(), что бы они корректно работали и учитывая данные объекта
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
