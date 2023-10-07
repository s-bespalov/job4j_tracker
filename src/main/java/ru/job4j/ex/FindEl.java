package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < values.length; i++) {
            if (key.equals(values[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element " + key + "not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] arr = {"Sergei", "Theodore", "Viktoria", "Elena"};
        try {
            int idx = indexOf(arr, "Elena");
            System.out.println("Index of \"Elena\": " + idx);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
