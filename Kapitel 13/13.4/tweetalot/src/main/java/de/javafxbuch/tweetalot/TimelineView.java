package de.javafxbuch.tweetalot;

import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import twitter4j.Status;

/**
 *
 * @author antonepple
 */
public final class TimelineView extends VBox{
    
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
