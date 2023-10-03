package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летит по воздуху");
    }

    @Override
    public void stop() {
        System.out.println("Самолет садиться");
    }
}
