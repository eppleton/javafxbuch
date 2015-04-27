/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import java.util.Arrays;

/**
 *
 * @author antonepple
 */
class Series {
    private final String title;
    private final float[] seriesData;

    public Series(String title, float[] seriesData) {
        this.title = title;
        this.seriesData = seriesData;
    }

    public String getTitle() {
        return title;
    }
    
    public String getSeriesDataAsString(){
        return Arrays.toString(seriesData);
    } 
}
