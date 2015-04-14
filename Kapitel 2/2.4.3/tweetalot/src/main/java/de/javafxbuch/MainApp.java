package de.javafxbuch;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Label label = new Label();
        root.getChildren().add(label);
        try {
            Twitter twitter = TwitterFactory.getSingleton();
            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
            label.setText(homeTimeline.get(0).getText());
        } catch (TwitterException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(new Scene(root));
        stage.setTitle("Tweetalot");
        stage.show();
    }

}
