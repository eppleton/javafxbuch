package de.javafxbuch;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author antonepple
 */
public class InterpolatorDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Interpolator SQUARE_INTERPOLATOR = new Interpolator() {
            @Override
            protected double curve(double t) {
                return t * t;
            }
        };
        Interpolator CUBIC_INTERPOLATOR = new Interpolator() {
            @Override
            protected double curve(double t) {
                return t * t * t;
            }
        };

        Circle circle0 = new Circle(100, 100, 50, Color.RED);
        Circle circle1 = new Circle(100, 300, 50, Color.RED);
        Circle circle2 = new Circle(100, 500, 50, Color.RED);
        Duration sec3 = Duration.seconds(3);
        TranslateTransition t0 = new TranslateTransition(sec3, circle0);
        t0.setByX(800);
        t0.setInterpolator(Interpolator.EASE_IN);
        t0.setAutoReverse(true);
        t0.setCycleCount(10);
        t0.play();
        TranslateTransition t1 = new TranslateTransition(sec3, circle1);
        t1.setByX(800);
        t1.setInterpolator(SQUARE_INTERPOLATOR);
        t1.setAutoReverse(true);
        t1.setCycleCount(10);
        t1.play();
        TranslateTransition t2 = new TranslateTransition(sec3, circle2);
        t2.setByX(800);
        t2.setInterpolator(CUBIC_INTERPOLATOR);
        t2.setAutoReverse(true);
        t2.setCycleCount(10);
        t2.play();
        Scene scene = new Scene(new Group(circle0, circle1, circle2), 1200, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
