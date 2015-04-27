package de.javafxbuch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author antonepple
 */
public class MiniPlayer extends Application {

    private double initialX;
    private double initialY;

    @Override
    public void start(Stage primaryStage) {
        Media media = new Media(getClass().getResource(
                "CodeHard.mp3").toString()
        );
        Button play = new Button();
        play.getStyleClass().addAll("player-button", "play");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.statusProperty().addListener((e, o, n) -> {
            if (n.equals(Status.PLAYING)) {
                play.getStyleClass().remove("play");
                play.getStyleClass().add("pause");
            } else {
                play.getStyleClass().add("play");
                play.getStyleClass().remove("pause");
            }
        });
        play.setOnAction(e -> {
            if (mediaPlayer.getStatus().equals(Status.PLAYING)) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.play();
            }
        });
        Button stop = new Button();
        stop.getStyleClass().add("player-button");
        stop.setId("stop");
        stop.setOnAction(e -> mediaPlayer.stop());
        Button quit = new Button();
        quit.getStyleClass().add("player-button");
        quit.setId("quit");
        quit.setOnAction(e -> Platform.exit());
        HBox root = new HBox();
        root.getStyleClass().add("background-region");
        root.getChildren().addAll(play, stop, quit);
        Scene scene = new Scene(root);

        scene.setOnMousePressed(me -> {
            initialX = me.getSceneX();
            initialY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            primaryStage.setX(me.getScreenX() - initialX);
            primaryStage.setY(me.getScreenY() - initialY);
        });
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(MiniPlayer.class.getResource("audioplayer.css").toString());
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
