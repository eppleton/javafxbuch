/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch.tweetalot;

import javafx.collections.ObservableListBase;
import twitter4j.ResponseList;
import twitter4j.Status;

/**
 *
 * @author antonepple
 */
public class ObservableTimelineList extends ObservableListBase<Status> {

    ResponseList<Status> delegate;

    public ObservableTimelineList(ResponseList<Status> delegate) {
        this.delegate = delegate;
    }

    public void setDelegate(ResponseList<Status> delegate) {
        
        beginChange();
        try {
            for (int i = 1; i < size(); ++i) {
                remove(i);
            }
       
        this.delegate = delegate;
        
            for (int i = 1; i < size(); ++i) {
                add(get(i));
            }
        } finally {
            endChange();
        }
    }

    @Override
    public Status get(int index) {
        return delegate.get(index);
    }

    @Override
    public int size() {
        return delegate.size();
    }

}
