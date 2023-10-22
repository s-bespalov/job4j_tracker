package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByPriority implements Comparator<Job> {
    @Override
    public int compare(Job left, Job right) {
        return Integer.compare(left.getPriority(), right.getPriority());
    }
}
