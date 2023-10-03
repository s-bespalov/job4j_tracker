package ru.job4j.poly;

public class Bus implements Transport {

    private int passengers = 0;

    @Override
    public void ride() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int count) {
        passengers += count;
        System.out.println("Пассажиров в автобусе: " + passengers);
    }

    @Override
    public float refuel(float volume) {
        return .5f * volume;
    }
}
