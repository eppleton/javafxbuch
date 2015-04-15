package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ToggleButton toggleButton = new ToggleButton("Option 1");
        ToggleButton toggleButton2 = new ToggleButton("Option 2");
        ToggleButton toggleButton3 = new ToggleButton("Option 3");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);
        VBox vBox = new VBox(toggleButton, toggleButton2, toggleButton3);
        vBox.setPadding(new Insets(20));
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
