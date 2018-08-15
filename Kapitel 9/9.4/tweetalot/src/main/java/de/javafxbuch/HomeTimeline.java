package de.javafxbuch;

import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class HomeTimeline extends ScrollPane {
    
    private TimelineView timelineView;
    private final RefreshService refreshService;
    
    public HomeTimeline() {
        setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setFitToWidth(true);
        refreshService = new RefreshService();
        refreshService.setPeriod(Duration.minutes(2));
        refreshService.setRestartOnFailure(true);
        refreshService.setMaximumFailureCount(3);
        refreshService.setBackoffStrategy(ScheduledService.EXPONENTIAL_BACKOFF_STRATEGY);
        
        refreshService.start();
        refreshService.setOnSucceeded((WorkerStateEvent event) -> {
            ObservableTimelineList value = refreshService.getValue();
            update(value);
        });
        refreshService.setOnFailed(e -> {
            System.out.println("Failed!");
        });
    }
    
    public void refresh() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
        ObservableTimelineList observableTimelineList = new ObservableTimelineList(homeTimeline);
        update(observableTimelineList);
    }
    
    private void update(ObservableTimelineList value) {
        if (timelineView == null) {
            timelineView = new TimelineView(value);
            setContent(timelineView);
        } else {
            timelineView.setStatusList(value);
        }
    }
    
    public final class TimelineView extends VBox {
        
        ObservableList<Status> statusList;
        
        public TimelineView(ObservableList<Status> statusList) {
            setStatusList(statusList);
        }
        
        public void setStatusList(ObservableList<Status> statusList) {
            this.statusList = statusList;
            updateView();
        }
        
        private void updateView() {
            getChildren().clear();
            for (Status status : statusList) {
                StatusView statusView = new StatusView();
                statusView.setStatus(status);
                getChildren().add(statusView);
            }
        }
    }
}
