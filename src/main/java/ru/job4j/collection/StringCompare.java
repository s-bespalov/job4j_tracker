package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int end = Integer.compare(left.length(), right.length()) < 0 ? right.length() : left.length();
        for (int i = 0; i < end; i++) {
            if (i == left.length()) {
                rsl = -1;
                break;
            }
            if (i == right.length()) {
                rsl = 1;
                break;
            }
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        return rsl;
    }
}
