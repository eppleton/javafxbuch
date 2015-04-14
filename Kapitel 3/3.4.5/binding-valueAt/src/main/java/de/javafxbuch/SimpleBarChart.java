/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import java.util.Set;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author antonepple
 */
public class SimpleBarChart extends VBox{
    final ObservableMap<String, Double> dataModel;

    public SimpleBarChart(ObservableMap<String, Double> dataModel) {
        super(10);
        setPadding(new Insets(20));
        this.dataModel = dataModel;
        
        Set<String> keySet = dataModel.keySet();
        int i = 0;
        for (String key : keySet) {
            Rectangle rectangle = new Rectangle(0,0,dataModel.get(key), 20);
            rectangle.widthProperty().bind(Bindings.doubleValueAt(dataModel, key));
            rectangle.getStyleClass().add("val"+i++);
            getChildren().add(new HBox(10,rectangle,new Label(key)) );
        }
    }
}
