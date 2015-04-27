package de.javafxbuch;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Rectangle rect = new Rectangle(100, 100, 100, 100);
        RotateTransition transition = new RotateTransition();
        transition.setNode(rect);
        transition.setDuration(Duration.seconds(1));
        transition.setFromAngle(0);
        transition.setToAngle(360);
        transition.play();

        root.getChildren().add(rect);
        Scene scene = new Scene(root, 300, 300);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
