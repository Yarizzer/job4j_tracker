package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает работу объекта пользователя сервиса
 * @author YAROSLAV ABATUROV
 * @version 1.0
 */

public class User {
    /**
     * Значение паспорта пользователя
     */
    private String passport;

    /**
     * Значение имени пользователя
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттеры и сеттеры полей класса
     */
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
