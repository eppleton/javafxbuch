package de.javafxbuch;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CounterService extends Service<Integer> {

    private final int max;

    public CounterService(int max) {
        this.max = max;
    }

    @Override
    protected Task<Integer> createTask() {
        return new CounterTask(max);
    }
}
