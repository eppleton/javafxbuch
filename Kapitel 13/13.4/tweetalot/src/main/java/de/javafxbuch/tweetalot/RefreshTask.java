/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.javafxbuch.tweetalot;

import javafx.concurrent.Task;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 *
 * @author antonepple
 */
public class RefreshTask extends Task<ObservableTimelineList> {
 
    @Override
    protected ObservableTimelineList call() throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
        ObservableTimelineList observableTimelineList = new ObservableTimelineList(homeTimeline);
        return observableTimelineList;
    }   
}
