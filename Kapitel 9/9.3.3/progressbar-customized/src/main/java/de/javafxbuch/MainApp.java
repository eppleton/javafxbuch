package de.javafxbuch;

import java.util.Optional;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        ProgressBar progressBar = new ProgressBar();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(progressBar.progressProperty(), 0.0)),
                new KeyFrame(Duration.seconds(20),
                        new KeyValue(progressBar.progressProperty(), 1.0)));
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                timeline.play();
                progressBar.setProgress(.01);
                ObservableList<Node> childrenUnmodifiable = progressBar.getChildrenUnmodifiable();
                Optional<Node> findFirst = childrenUnmodifiable.stream()
                        .filter(b -> b.getStyleClass().contains("bar")).findFirst();
                findFirst.get().styleProperty().bind(
                        new AnimationBinding());
            }
        });

        VBox root = new VBox(btn, progressBar);

        Scene scene = new Scene(root, 300, 250);
//        scene.getStylesheets().add("progressbar/css/progressbar.css");
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
//        ScenicView.show(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private static class AnimationBinding extends StringBinding {

        private final DoubleProperty animationProperty;

        public AnimationBinding() {
            this.animationProperty = new SimpleDoubleProperty(0.0);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(animationProperty, 0.0)),
                    new KeyFrame(Duration.seconds(4),
                            new KeyValue(animationProperty, 1.0)));
            timeline.setCycleCount(Animation.INDEFINITE);
            super.bind(animationProperty);
            timeline.play();
        }

        @Override
        protected String computeValue() {
            double val = animationProperty.get();
            double x = -val * 100 % 20;
            return "    -fx-background-color: linear-gradient(\n"
                    + "        from " + x + "px " + x + "px to " + (x + 10) + "px " + (x + 10) + "px ,\n"
                    + "        repeat,\n"
                    + "        -fx-accent 49%,\n"
                    + "        -fx-accent 0%,\n"
                    + "        \n"
                    + "        derive(-fx-accent, 30%) 50%,\n"
                    + "        derive(-fx-accent, 30%) 99%\n"
                    + "    );\n";
        }
    }

}
