package de.javafxbuch.tweetalot;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.ScrollPane;
import javafx.util.Duration;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author antonepple
 */
public class HomeTimeline extends ScrollPane {

    private TimelineView timelineView;

    public HomeTimeline() {
        setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setFitToWidth(true);
        RefreshService refreshService = new RefreshService();
        refreshService.setPeriod(Duration.seconds(20));
        refreshService.setRestartOnFailure(true);
        refreshService.setMaximumFailureCount(3);
        refreshService.setBackoffStrategy(ScheduledService.EXPONENTIAL_BACKOFF_STRATEGY);
        
        refreshService.start();
        refreshService.setOnSucceeded((WorkerStateEvent event) -> {
            ObservableTimelineList value = refreshService.getValue();
            update(value);
        });
    }

    public void refresh() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
        ObservableTimelineList observableTimelineList = new ObservableTimelineList(homeTimeline);

    }

    private void update(ObservableTimelineList value) {
        if (timelineView == null) {
            timelineView = new TimelineView(value);
            setContent(timelineView);
        } else {
            timelineView.setStatusList(value);
        }
    }
}
