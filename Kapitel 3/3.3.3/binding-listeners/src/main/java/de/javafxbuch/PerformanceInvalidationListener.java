package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class PerformanceInvalidationListener extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DoubleProperty number1 = new SimpleDoubleProperty(1);
        DoubleProperty number2 = new SimpleDoubleProperty(2);
        DoubleProperty number3 = new SimpleDoubleProperty(3);
        NumberBinding calculated = Bindings.add(number1,
                Bindings.multiply(number2, number3));
        calculated.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    // ignorieren wir hier ausnahmsweise
                }
                System.out.println("Wert ungültig!");
                // fügen Sie die nächste Zeile ein, un Testen Sie das Beispiel noch einmal
//                System.out.println("Wert ungültig!"+calculated.getValue());
            }
        });
        number1.setValue(90);
        number1.setValue(10);
        Slider slider = new Slider(0, 100, 50);
        number1.bind(slider.valueProperty());
        Scene scene = new Scene(slider, 400, 100);
        primaryStage.setTitle("InvalidationListener");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
