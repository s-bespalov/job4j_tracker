package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split("/");
        String[] arrRight = right.split("/");
        int first = arrRight[0].compareTo(arrLeft[0]);
        if (first != 0) {
            return first;
        }
        for (int i = 1; i < Math.min(arrLeft.length, arrRight.length); i++) {
            int second = arrLeft[i].compareTo(arrRight[i]);
            if (second != 0) {
                return second;
            }
        }
        return Integer.compare(arrLeft.length, arrRight.length);
    }
}
