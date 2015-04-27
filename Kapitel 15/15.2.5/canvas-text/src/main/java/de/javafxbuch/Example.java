package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Example extends Application {

    @Override
    public void start(Stage stage) {
        final Canvas canvas = new Canvas(500, 400);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
// Einfacher Text
        gc.fillText("Lorem ipsum", 100, 100);
        // Text über mehrere Zeilen
        gc.fillText(
                "Lorem ipsum dolor sit amet,\n"
                + "consectetur adipiscing elit.\n"
                + "Donec suscipit viverra egestas.",
                100, 150
        );
// Gestauchter Text
        gc.fillText("Lorem ipsum dolor sit amet", 100, 240, 100);

        final Group root = new Group(canvas);
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
