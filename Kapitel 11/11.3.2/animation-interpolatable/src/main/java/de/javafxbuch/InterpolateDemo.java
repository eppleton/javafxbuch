package de.javafxbuch;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author antonepple
 */
public class InterpolateDemo extends Application {

    private static Image IMAGE = new Image(InterpolateDemo.class.getResourceAsStream("DukeWithHelmet.png"));

    @Override
    public void start(Stage primaryStage) {
        final ImageView imageView = new ImageView(IMAGE);
        final KeyValue keyValue0 = new KeyValue(imageView.viewportProperty(),
                new InterpolatableRectangle2D(0, 150, 100, 100)
        );
        final KeyFrame keyFrame0 = new KeyFrame(
                Duration.seconds(0),
                keyValue0);
        final KeyValue keyValue1 = new KeyValue(imageView.viewportProperty(),
                new InterpolatableRectangle2D(400, 150, 100, 100)
        );
        final KeyFrame keyFrame1 = new KeyFrame(
                Duration.seconds(2),
                keyValue1);
        new Timeline(keyFrame0, keyFrame1).play();

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 800,600);

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
