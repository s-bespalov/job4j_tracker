package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftN = Integer.parseInt(left.split("[.]")[0]);
        int rightN = Integer.parseInt(right.split("[.]")[0]);
        return Integer.compare(leftN, rightN);
    }
}
