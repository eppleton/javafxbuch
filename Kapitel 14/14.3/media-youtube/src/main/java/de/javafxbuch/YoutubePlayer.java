package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class YoutubePlayer extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView embeddeWV = new WebView();
        embeddeWV.getEngine().load("http://www.youtube.com/embed/Mk3qkQROb_k?autoplay=1");
        embeddeWV.setPrefSize(640, 400);
        primaryStage.setScene(new Scene(embeddeWV));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
