package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        String created = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss").format(item.getCreated());
        System.out.println(created);
    }
}
