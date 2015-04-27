package de.javafxbuch;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        Circle circle = new Circle(200, 400, 100, Color.AZURE);

        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.seconds(2));
        translate.setByX(800);

        ScaleTransition scale1 = new ScaleTransition();
        scale1.setDuration(Duration.millis(300));
        scale1.setFromX(0.95);
        scale1.setToX(1.05);
        scale1.setFromY(1.05);
        scale1.setToY(0.95);

        ScaleTransition scale2 = new ScaleTransition();
        scale2.setDuration(Duration.millis(300));
        scale2.setFromX(1.05);
        scale2.setToX(0.95);
        scale2.setFromY(0.95);
        scale2.setToY(1.05);

        PauseTransition pause = new PauseTransition();
        pause.setDuration(Duration.millis(1400));

        SequentialTransition sequential
                = new SequentialTransition(scale1, pause, scale2);

        ParallelTransition parallel
                = new ParallelTransition(circle, translate, sequential);
        parallel.setCycleCount(Animation.INDEFINITE);
        parallel.setAutoReverse(true);
        parallel.play();

        Group root = new Group(circle);
        Scene scene = new Scene(root, 1200, 600);
        scene.setFill(Color.BLACK);

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
