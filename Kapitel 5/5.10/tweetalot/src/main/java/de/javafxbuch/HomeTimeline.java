/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class HomeTimeline extends ScrollPane {

    private TimelineView timelineView;

    public HomeTimeline() {
        setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setFitToWidth(true);
    }

    public void refresh() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        ResponseList<Status> homeTimeline = twitter
                .getHomeTimeline();
        ObservableTimelineList observableTimelineList
                = new ObservableTimelineList(homeTimeline);
        if (timelineView == null) {
            timelineView = new TimelineView(observableTimelineList);
            setContent(timelineView);
        } else {
            timelineView.setStatusList(observableTimelineList);
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
