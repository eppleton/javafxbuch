/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

/**
 *
 * @author antonepple
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        DoubleProperty number1 = new SimpleDoubleProperty(1);
        DoubleProperty number2 = new SimpleDoubleProperty(2);
        number2.bindBidirectional(number1);
        number2.setValue(3);
        number1.setValue(4);
        System.out.println("number2 hat den Wert " + number2.getValue());
        // unbind hebt das Binding wieder auf
        number2.unbindBidirectional(number1);
        number1.setValue(10);
        System.out.println("number2 hat den Wert " + number2.getValue());
        Platform.exit();
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
