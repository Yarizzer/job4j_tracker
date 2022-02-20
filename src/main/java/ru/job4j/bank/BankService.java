package ru.job4j.bank;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу объекта банковского сервиса
 * Цели
 * - Добавление пользователя
 * - Добавление счёта
 * - Поиск пользователя по данным паспорта и счёту
 * - Поиск счёта по реквизиту и паспорту пользователя
 * - Перевод средств
 * @author YAROSLAV ABATUROV
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение пользователей и их счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавлдение пользователя в сервис
     * @param user добавляемы пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавлдение счёта
     * @param passport строковое значение паспорта пользователя
     * @param account значение добавляемого счёта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Поиск счёта по реквизиту и паспорту пользователя
     * @param passport строковое значение паспорта пользователя
     * @return возвращает найденное значение пользователя
     */
    public User findByPassport(String passport) {
        User res = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                res = user;
                break;
            }
        }
        return res;
    }

    /**
     * Поиск счёта по реквизиту и паспорту пользователяя
     * @param passport строковое значение паспорта пользователя
     * @param requisite строковое значение реквизита счёта
     * @return возвращает найденное значение счёта
     */
    public Account findByRequisite(String passport, String requisite) {
        Account res = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    res = account;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Перевод средств
     * @param srcPassport строковое значение паспорта пользователя отправителя
     * @param srcRequisite строковое значение реквизита счёта отправителя
     * @param destPassport строковое значение паспорта пользователя получателя
     * @param destRequisite строковое значение реквизита счёта получателя
     * @param amount переводимая сумма
     * @return возвращает true при успешном переводе, false при ошибке
     * При переводе проходят проверки
     * - счёта отправителя != null
     * - счёта получателя != null
     * - баланс счёта отправителя >= переводимой суммы
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
