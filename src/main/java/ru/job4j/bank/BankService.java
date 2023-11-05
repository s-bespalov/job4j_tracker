package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис
 *
 * @author Sergey Bespalov
 * @version 1.0
 */
public class BankService {
    /**
     * Список пользователей и их счетов хранится в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удалить пользователя с указанным номером паспорта
     *
     * @param passport номер паспорта удаляемого пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, null));
    }

    /**
     * Добавить банковский счет пользователю
     *
     * @param passport номер паспорта пользователя, которому будет добавлен счет
     * @param account  добавляемы счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Найти пользователя по номеру паспорта
     *
     * @param passport номер паспорта
     * @return возвращает пользователя - объект класса {@link User}
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Найти счет по реквизитам
     *
     * @param passport  номер паспорта пользователя, которому принадлежит счет
     * @param requisite реквизиты банковского счета
     * @return возвращает банковский счет - объект класса {@link Account}
     */
    public Account findByRequisite(String passport, String requisite) {
        return users.entrySet()
                .stream()
                .filter(e -> passport.equals(e.getKey().getPassport()))
                .flatMap(e -> e.getValue().stream())
                .filter(a -> requisite.equals(a.getRequisite()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Перевод денег между пользователями
     *
     * @param srcPassport   номер паспорта пользователя совершающего перевод
     * @param srcRequisite  реквизиты счета с которого производится перевод
     * @param destPassport  номер паспорта пользователя которому отправляется перевод
     * @param destRequisite реквизиты счета на который отправляется перевод
     * @param amount        сумма, которая будет переведена
     * @return возвращает {@code true} если перевод прошел успешно, если произошла ошибка - {@code false}
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        if (srcAccount == null || srcAccount.getBalance() < amount) {
            return false;
        }
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount == null) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }

    /**
     * Получить список счетов пользователя
     *
     * @param user объект класса {@link User}
     * @return возвращает список счетов пользователя - коллекцию типа {@link List}
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
