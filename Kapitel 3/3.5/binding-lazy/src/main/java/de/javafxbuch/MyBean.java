/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyBean implements Serializable {

    private StringProperty sample;
    private String sampleDummy;

    public String getSample() {
        return sample == null ? sampleDummy : sample.get();
    }

    public void setSample(String value) {
        if (sample == null) {
            sampleDummy = value;
        } else {
            sample.set(value);
        }
    }

    public StringProperty sampleProperty() {
        if (sample == null) {
            sample = new SimpleStringProperty(sampleDummy);
        }
        return sample;
    }
}
