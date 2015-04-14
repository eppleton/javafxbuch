package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HackablePerson hans = new HackablePerson("Hans");
        try {
            ((StringProperty) hans.nameProperty()).set("Peter");
        } catch (Exception e) {
            System.err.println("Das passiert nicht!");
        }
        System.out.println("Hans heisst jetzt " + hans.getName());

        Person paula = new Person("Paula");
        try {
            ((StringProperty) paula.nameProperty()).set("Iris");
        } catch (Exception e) {
            System.err.println("Das ist verboten!");
        }
        System.out.println("Paula heisst immer noch "+paula.getName());
    }

}
