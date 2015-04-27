package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Example extends Application {

    private static Image IMAGE = new Image(Example.class.getResourceAsStream("DukeWithHelmet.png"));
    
    @Override
    public void start(Stage stage) {
        final Canvas canvas = new Canvas(1280, 720);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        // Bild in Originalgröße
        gc.drawImage(IMAGE, 100, 100);
// Bild skaliert
        gc.drawImage(IMAGE, 600, 228, 256, 256);
// Bildausschnitt skaliert
        gc.drawImage(IMAGE, 192, 128, 128, 128, 900, 228, 256, 256);
        final Group root = new Group(canvas);
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
