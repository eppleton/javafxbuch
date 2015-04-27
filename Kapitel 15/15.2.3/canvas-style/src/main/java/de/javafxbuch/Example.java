package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Example extends Application {

    @Override
    public void start(Stage stage) {
        final Canvas canvas = new Canvas(1280, 720);
        final GraphicsContext# gc = canvas.getGraphicsContext2D();
        // Rotes Quadrat 
        gc.setStroke(Color.RED);
        gc.strokeRect(100, 100, 100, 100);
// Blaues Quadrat mit breitem Rand 
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(20);
        gc.strokeRect(300, 100, 100, 100);
// Grünes gefülltes Quadrat 
        gc.setFill(Color.GREEN);
        gc.fillRect(100, 300, 100, 100);
        // Quadrat mit Gradientfüllung
        gc.setFill(
                new LinearGradient(
                        0.0, 0.0, 0.0, 1.0, true,
                        CycleMethod.NO_CYCLE,
                        new Stop(0.0, Color.WHITE),
                        new Stop(1.0, Color.BLACK)
                ));
        gc.fillRect(300, 300, 100, 100);
        final Group root = new Group(canvas);
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
