package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Drei mal das gleiche Binding auf verschiedene Weise umgesetzt:
        
        DoubleProperty number1 = new SimpleDoubleProperty(1);
        DoubleProperty number2 = new SimpleDoubleProperty(2);
        DoubleProperty number3 = new SimpleDoubleProperty(3);
        
        // Beispiel 1: Die Bindings Klasse mit statischen Methoden
        NumberBinding calculated = Bindings
                .add(number1, Bindings.multiply(number2, number3));
        
        // Beispiel 2: Die "fluent" API
        NumberBinding calculated2 = number1.add(number2.multiply(number3));
        
        // Beispiel 3: Die Low-Level API
        NumberBinding calculated3 = new DoubleBinding() {
            {
                super.bind(number1, number2, number3);
            }

            @Override
            protected double computeValue() {
                return number1.get() + (number2.get() * number3.get());
            }
        };
        
        System.out.println("Neuer Wert!");
        number1.set(10);
        System.out.println("Mit Bindings-Klasse: "+calculated.getValue());
        System.out.println("Mit fluent-API:      "+calculated2.getValue());
        System.out.println("Mit low-level-API: "+calculated3.getValue());
        System.out.println("Neuer Wert!");
        number2.set(7);
        System.out.println("Mit Bindings-Klasse: "+calculated.getValue());
        System.out.println("Mit fluent-API:      "+calculated2.getValue());
        System.out.println("Mit low-level-API: "+calculated3.getValue());

    }

}
