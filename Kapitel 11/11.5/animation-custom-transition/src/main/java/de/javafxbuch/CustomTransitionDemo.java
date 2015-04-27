package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author antonepple
 */
public class CustomTransitionDemo extends Application {

    private static Image IMAGE = new Image(CustomTransitionDemo.class.getResourceAsStream("DukeWithHelmet.png"));

    @Override
    public void start(Stage primaryStage) {
        final ImageView imageView = new ImageView(IMAGE);
        new ViewportTransition(
                imageView,
                new Rectangle2D(0, 150, 100, 100), new Rectangle2D(400, 150, 100, 100), Duration.seconds(2)
        ).play();

        Scene scene = new Scene(new Group(imageView), 1200, 600);

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
