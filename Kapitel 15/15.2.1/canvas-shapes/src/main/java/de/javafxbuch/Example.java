package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Example extends Application {

    @Override
    public void start(Stage stage) {
        final Canvas canvas = new Canvas(1280, 720);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        // Rechteck
        gc.strokeRect(100, 100, 100, 200);
// Rechteck mit runden Ecken gc.strokeRoundRect(250, 100, 100, 200, 20, 20);
        // Ellipse
        gc.strokeOval(400, 100, 100, 200);
// Kreisbogen
        gc.strokeArc(450, 100, 200, 200, 315, 90, ArcType.ROUND);
        //  Polygon
        gc.strokePolygon(
                new double[]{750, 800, 750, 700},
                new double[]{100, 200, 300, 200},
                4
        );
// Strecke
        gc.strokeLine(900, 100, 900, 300);
        // Streckenzug
        gc.strokePolyline(
                new double[]{1000, 1000, 1100, 1100},
                new double[]{100, 300, 300, 100},
                4
        );
// Gefülltes Rechteck 
        gc.fillRect(100, 400, 100, 200);
// Gefülltes Rechteck mit runden Ecken 
        gc.fillRoundRect(250, 400, 100, 200, 20, 20);
// Gefüllte Ellipse 
        gc.fillOval(400, 400, 100, 200);
// Gefüllter Kreisbogen
        gc.fillArc(450, 400, 200, 200, 315, 90, ArcType.ROUND);
        // Gefülltes Polygon
        gc.fillPolygon(
                new double[]{750, 800, 750, 700},
                new double[]{400, 500, 600, 500},
                4
        );
        final Group root = new Group(canvas);
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
