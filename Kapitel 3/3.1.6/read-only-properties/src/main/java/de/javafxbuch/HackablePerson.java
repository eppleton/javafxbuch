/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 *
 * @author antonepple
 */
public class HackablePerson {

    private final ReadOnlyStringProperty name;
    
    public HackablePerson(String name) {
        this.name = new ReadOnlyStringWrapper(name);
    }
    
    public final String getName() {
        return name.getValue();
    }

    public final ReadOnlyStringProperty nameProperty() {
        return name;
    }
}
