package de.javafxbuch;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class VideoPlayer extends Application {

    private double initialX;
    private double initialY;

    @Override
    public void start(Stage primaryStage) {
        Media media = new Media(getClass().getResource(
                "vid_bigbuckbunny.mp4").toString()
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
        Button fastfw = new Button();
        fastfw.getStyleClass().addAll("player-button", "fastfw");
        fastfw.setOnAction(e -> mediaPlayer.setRate(mediaPlayer.getRate() > 0
                ? (mediaPlayer.getRate() >= 8 ? 1 : mediaPlayer.getRate() * 2) : 2));
        Button fastbw = new Button();
        
         
         
        fastbw.getStyleClass().addAll("player-button", "fastbw");
        fastbw.setOnAction(e -> mediaPlayer.setRate(mediaPlayer.getRate() < 0
                ? (mediaPlayer.getRate() <= -8 ? 1 : mediaPlayer.getRate() * 2) : -2));
        Button stop = new Button();
        stop.getStyleClass().add("player-button");
        stop.setId("stop");
        stop.setOnAction(e -> mediaPlayer.stop());
        Button quit = new Button();
        quit.getStyleClass().add("player-button");
        quit.setId("quit");
        quit.setOnAction(e -> Platform.exit());
        HBox controls = new HBox();
        controls.getStyleClass().add("background-region");
        controls.getChildren().addAll(fastbw, play, stop, quit, fastfw);
        StackPane root = new StackPane();
        Text text = new Text("||");
        text.setOpacity(0);
        text.setScaleX(10);
        text.setScaleY(10);
        mediaPlayer.setOnPaused(new Runnable() {

            @Override
            public void run() {
                text.setOpacity(1);
            }
        });
        
         mediaPlayer.setOnPlaying(new Runnable() {

            @Override
            public void run() {
                text.setOpacity(0);
            }
        });
        root.getChildren().addAll(new MediaView(mediaPlayer), controls, text);
        Scene scene = new Scene(root, 640, 360);
        FadeTransition fade = new FadeTransition(Duration.millis(500), controls);
        fade.setFromValue(0);
        fade.setToValue(.5);
        scene.setOnMouseEntered(e -> {
            fade.setRate(1);
            fade.play();
        });
        scene.setOnMouseExited(e -> {
            fade.setRate(-1);
            fade.play();
        });
        scene.setOnMousePressed(me -> {
            initialX = me.getSceneX();
            initialY = me.getSceneY();
        });
        scene.setOnMouseDragged(me -> {
            primaryStage.setX(me.getScreenX() - initialX);
            primaryStage.setY(me.getScreenY() - initialY);
        });
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(VideoPlayer.class.getResource("audioplayer.css").toString());
        primaryStage.setTitle(
                "Hello World!");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
