package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student elena = new Student();
        elena.setName("Елена Н.С.");
        elena.setGroup("451A");
        elena.setAdmissionDate(LocalDate.of(2024, Month.SEPTEMBER, 9));
        System.out.println("Name: " + elena.getName());
        System.out.println("Group: " + elena.getGroup());
        System.out.println("Admission date: "
                + elena.getAdmissionDate().format(DateTimeFormatter.ofPattern("d MMM yyyy")));
    }
}
