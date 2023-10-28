package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> testPhone = p -> p.getPhone().contains(key);
        Predicate<Person> testName = p -> p.getName().contains(key);
        Predicate<Person> testSurname = p -> p.getSurname().contains(key);
        Predicate<Person> testAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = testPhone.or(testName).or(testAddress).or(testSurname);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
