package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public double divide(int y) {
        return (double) y / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return  y - x;
    }

    public double  sumAllOperations(int y) {
        return divide(y) + sum(y) + multiply(y) + minus(y);
    }

    public static void main(String[] args) {
        int y = 2;
        System.out.println(new Calculator().divide(y));
        System.out.println(new Calculator().multiply(y));
        System.out.println(sum(y));
        System.out.println(minus(y));
        System.out.println(new Calculator().sumAllOperations(y));
    }
}
