package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;
    private Customer lastHappy;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
        process();
    }

    private void process() {
        for (int i = 0; i < count; i++) {
            lastHappy = queue.poll();
        }
    }

    public String getLastHappyCustomer() {
        return lastHappy.name();
    }

    public String getFirstUpsetCustomer() {
        Customer client = queue.peek();
        return client != null ? client.name() : null;
    }
}
