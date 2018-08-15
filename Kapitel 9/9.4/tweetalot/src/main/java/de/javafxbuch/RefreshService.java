package de.javafxbuch;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class RefreshService extends ScheduledService<ObservableTimelineList> {

	@Override
	protected Task<ObservableTimelineList> createTask() {
		return new RefreshTask();
	}
}
