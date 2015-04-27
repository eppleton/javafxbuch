package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Example extends Application {

    @Override
    public void start(Stage stage) {
        final Canvas canvas = new Canvas(500, 400);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.rotate(-45);
        gc.fillRect(0, 300, 100, 200);

        final Group root = new Group(canvas);
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
