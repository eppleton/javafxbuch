package de.javafxbuch;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyBean implements Serializable {

    private final StringProperty sample = new SimpleStringProperty();

    public String getSample() {
        return sample.get();
    }

    public void setSample(String value) {
        sample.set(value);
    }

    public StringProperty sampleProperty() {
        return sample;
    }
}
