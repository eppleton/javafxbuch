package de.javafxbuch;

import javafx.concurrent.Task;

public class CounterTask extends Task<Integer> {

    int max;

    public CounterTask(int max) {
        this.max = max;
        updateMessage("Ready to count...");
    }

    @Override
    protected Integer call() throws Exception {
        updateMessage("Counting...");
        for (int i = 0; i < max; i++) {
            Thread.sleep(10);
            updateProgress(i, max);
        }
// folgende Zeilen einkommentieren um einen Fehler zu simulieren:
//        if (max >= 3) {
//            throw new Exception("Das ist zu kompliziert!");
//        }

        updateMessage("READY");
        return max;
    }
}
