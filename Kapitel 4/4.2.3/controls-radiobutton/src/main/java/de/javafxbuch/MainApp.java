package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        RadioButton radioButton = new RadioButton("Option 1");
        RadioButton radioButton2 = new RadioButton("Option 2");
        RadioButton radioButton3 = new RadioButton("Option 3");
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        VBox vBox = new VBox(5, radioButton, radioButton2, radioButton3);
        vBox.setPadding(new Insets(20));
        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
