package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("theodor1378@tmpmail.com", "Theodor");
        map.put("nina8756@tmpmail.com", "Nina");
        map.put("nina8756@tmpmail.com", "Anna");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
