package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class KochFlocke extends Application {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int LINE_LENGTH = 500;
    private GraphicsContext gc;

    @Override
    public void start(Stage stage) {
        final Canvas canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        drawSnowflake();
        final Group root = new Group(canvas);
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void drawSnowflake() {
        gc.translate(WIDTH / 2, 80);
        gc.rotate(60.0);
        drawKochCurve(LINE_LENGTH);
        gc.rotate(120.0);
        drawKochCurve(LINE_LENGTH);
        gc.rotate(120.0);
        drawKochCurve(LINE_LENGTH);
    }

    private void drawKochCurve(double length) {
        if (length < 1) {
            gc.strokeLine(0, 0, length, 0);
            gc.translate(length, 0);
        } else {
            final double newLength = length / 3;
            drawKochCurve(newLength);
            gc.rotate(-60.0);
            drawKochCurve(newLength);
            gc.rotate(120.0);
            drawKochCurve(newLength);
            gc.rotate(-60.0);
            drawKochCurve(newLength);
        }
    }

}
