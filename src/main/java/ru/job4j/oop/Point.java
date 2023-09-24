package ru.job4j.oop;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {

    private int x;

    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow(that.x - this.x, 2) + pow(that.y - this.y, 2));
    }

    public static void main(String[] args) {
        Point p = new Point(10, 20);
        double d = p.distance(new Point(1000, 1000));
        System.out.println(d);
    }
}
