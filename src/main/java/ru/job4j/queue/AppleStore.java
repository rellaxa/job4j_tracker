package ru.job4j.queue;


import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 0; i < queue.size(); i++) {
            Customer customer = queue.poll();
            if (i + 1 == count) {
                return customer.name();
            }
        }
        return "";
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i <= queue.size() + 1; i++) {
            Customer customer = queue.poll();
            if (i == count) {
                return customer.name();
            }
        }
        return "";
    }
}