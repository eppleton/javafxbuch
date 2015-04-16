package de.javafxbuch;

import javafx.concurrent.Task;
import javafx.util.Duration;

public class CounterService extends javafx.concurrent.ScheduledService<Integer> {

    private final int max;

    public CounterService(int max) {
        setPeriod(Duration.seconds(2));
        this.max = max;
    }

    @Override
    protected Task<Integer> createTask() {
        return new CounterTask(max);
    }
}
