package ru.job4j.bank;

import java.util.*;

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
        var user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Поиск счёта по реквизиту и паспорту пользователя
     * @param passport строковое значение паспорта пользователя
     * @return возвращает найденное значение пользователя
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(v -> v.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск счёта по реквизиту и паспорту пользователяя
     * @param passport строковое значение паспорта пользователя
     * @param requisite строковое значение реквизита счёта
     * @return возвращает найденное значение счёта
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        Optional<Account>  rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(v -> v.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        var srcAccount = findByRequisite(srcPassport, srcRequisite);
        var destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
