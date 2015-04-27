package de.javafxbuch;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
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

        final Rectangle rect = new Rectangle(100, 100);
        final Circle circle = new Circle(200, 200, 100);
        final PathTransition transition = new PathTransition();
        transition.setNode(rect);
        transition.setDuration(Duration.seconds(5));
        transition.setPath(circle);
        transition.setOrientation(
                OrientationType.ORTHOGONAL_TO_TANGENT);
        transition.play();
        root.getChildren().add(rect);
        Scene scene = new Scene(root, 1024, 800);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
