package de.javafxbuch.tweetalot;

import javafx.concurrent.Task;

/**
 *
 * @author antonepple
 */
public class RefreshService extends javafx.concurrent.ScheduledService<ObservableTimelineList>{

    @Override
    protected Task<ObservableTimelineList> createTask() {
        return new RefreshTask();
    } 
}
