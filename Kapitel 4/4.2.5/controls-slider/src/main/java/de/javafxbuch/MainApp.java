package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Slider slider = new Slider(0, 1, .5);
        Circle circle = new Circle(50, Color.RED);
        circle.scaleXProperty().bind(slider.valueProperty());
        circle.scaleYProperty().bind(slider.valueProperty());
       
        StackPane root = new StackPane();
        root.getChildren().addAll(circle, slider);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
