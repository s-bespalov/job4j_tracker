package ru.job4j.stream;

import ru.job4j.pojo.Person;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.parallelStream()
                .reduce(
                        1,
                        (a, b) -> {
                            int rsl = a;
                            if (b.getAge() > 25) {
                                rsl += b.getAge();
                            }
                            System.out.println("reduce accumulator, a: " + a + " b:" + b + "result: " + rsl);
                            return rsl;
                        },
                        (a, b) -> {
                            int rsl = a + b;
                            System.out.println("reduce combiner, a: " + a + " b:" + b + " result: " + rsl);
                            return rsl;
                        }
                );
        System.out.println(sum);
    }
}