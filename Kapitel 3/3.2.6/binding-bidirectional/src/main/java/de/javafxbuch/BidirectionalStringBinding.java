/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author antonepple
 */
public class BidirectionalStringBinding extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
    
        TextField textField = new TextField();
        Slider slider = new Slider();
        StringProperty sp = textField.textProperty();
        DoubleProperty dp = slider.valueProperty();
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(sp, dp, converter);
        VBox root = new VBox(slider, textField);
        Scene scene = new Scene(root, 400,400);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
