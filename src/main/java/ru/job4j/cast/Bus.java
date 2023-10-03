package ru.job4j.cast;

public class Bus implements Vehicle{
    @Override
    public void move() {
        System.out.println("Автобус едет по скоростной трассе");
    }

    @Override
    public void stop() {
        System.out.println("Автобус останавливается");
    }
}
