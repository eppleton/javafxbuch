/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
