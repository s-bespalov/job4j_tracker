package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split("/");
        String[] arrRight = right.split("/");
        int first = arrRight[0].compareTo(arrLeft[0]);
        return first != 0 ? first : left.compareTo(right);
    }
}
