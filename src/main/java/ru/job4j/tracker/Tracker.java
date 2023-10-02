package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int idx = indexOf(id);
        return idx >= 0 ? items[idx] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String name) {
        Item[] rsl = new Item[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (name.equals(items[i].getName())) {
                rsl[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(rsl, j);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public void delete(int id) {
        int idx = indexOf(id);
        if (idx != -1) {
            System.arraycopy(items, idx + 1, items, idx, size - idx - 1);
            items[size - 1] = null;
            size--;
        }
    }
}