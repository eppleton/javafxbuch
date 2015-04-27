package de.javafxbuch;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
        TranslateTransition transition = new TranslateTransition();
        Rectangle rect = new Rectangle(100,100, 100, 100);
        transition.setNode(rect);
        // Bewege den Node von der aktuellen Position nach (100, 100) 
        transition.setToX(100);
        transition.setToY(100);
// Bewege den Node von (100, 100) nach (200, 300) 
        transition.setFromX(100);
        transition.setFromY(100);
        transition.setToX(200);
        transition.setToY(300);
// Bewege den Node von der aktuellen Position, um (100, 200) transition.setByX(100);
        transition.setByY(200);
// Bewege den Node von (100, 100), um (100, 200) transition.setFromX(100); transition.setFromY(100); transition.setByX(100);
        transition.setByY(200);

        rect.setOnMouseClicked(e -> transition.play());
        root.getChildren().add(rect);
        Scene scene = new Scene(root, 1024, 800);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
