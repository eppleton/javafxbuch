package de.javafxbuch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
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

        DoubleProperty number1 = new SimpleDoubleProperty(1);
        DoubleProperty number2 = new SimpleDoubleProperty(2);
        DoubleProperty number3 = new SimpleDoubleProperty(3);
        NumberBinding calculated = Bindings.add(number1, Bindings.multiply(number2, number3));
        calculated.addListener((Observable observable) -> {
            System.out.println("Das Binding ist ungültig");
        });
        number1.setValue(90);
    // die nächste Änderung bekommt ein InvalidationListener nicht mehr mit: 
        number1.setValue(10);
        Platform.exit();
    }

}
