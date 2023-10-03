package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Bus saab = new Bus();
        Plane boeing = new Plane();
        Train sapsan = new Train();
        Vehicle[] vehicles = {saab, boeing, sapsan};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.stop();
        }
    }
}
