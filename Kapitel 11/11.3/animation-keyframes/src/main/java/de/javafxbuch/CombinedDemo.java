package de.javafxbuch;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author antonepple
 */
public class CombinedDemo extends Application {

    private ImageView nerd;

    @Override
    public void start(Stage primaryStage) {
        final Rectangle rect = new Rectangle(100, 100, 100, 100);
        final KeyFrame keyFrame0 = new KeyFrame(Duration.millis(0),
                new KeyValue(rect.arcWidthProperty(), 0), new KeyValue(rect.arcHeightProperty(), 0)
        );
        final KeyFrame keyFrame1 = new KeyFrame(Duration.millis(800),
                new KeyValue(rect.arcWidthProperty(), 5), new KeyValue(rect.arcHeightProperty(), 20)
        );
        final KeyFrame keyFrame2 = new KeyFrame(
                Duration.millis(1000),
                new KeyValue(rect.arcWidthProperty(), 15), new KeyValue(rect.arcHeightProperty(), 15)
        );
        new Timeline(
                keyFrame0, keyFrame1, keyFrame2
        ).play();
        Group root = new Group(rect);
        Scene scene = new Scene(root, 300, 300);

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
