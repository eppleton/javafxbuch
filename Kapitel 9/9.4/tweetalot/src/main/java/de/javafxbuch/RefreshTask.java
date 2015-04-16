package de.javafxbuch;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class RefreshTask extends Task<ObservableTimelineList> {

    @Override
    protected ObservableTimelineList call()  {
        try {
            Twitter twitter = TwitterFactory.getSingleton();
            ResponseList<Status> homeTimeline = twitter
                    .getHomeTimeline();
            ObservableTimelineList observableTimelineList
                    = new ObservableTimelineList(homeTimeline);
            return observableTimelineList;
        } catch (TwitterException ex) {
            Logger.getLogger(RefreshTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
