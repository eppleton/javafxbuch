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
        final Canvas canvas = new Canvas(1280, 720);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.beginPath();
        gc.arc(300, 200, 150, 50, 0, 360);
        gc.moveTo(150, 200);
        gc.lineTo(150, 500);
        gc.arc(300, 500, 150, 50, 180, 180);
        gc.lineTo(450, 200);
        gc.stroke();
        final Group root = new Group(canvas);
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
