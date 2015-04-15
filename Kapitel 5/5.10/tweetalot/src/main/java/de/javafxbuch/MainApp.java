package de.javafxbuch;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
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
    public void start(Stage stage) throws Exception {
        Font.loadFont(getClass().getResource("fontawesome-webfont.ttf").
                toExternalForm(), 12);
        Button button = new Button("\uf015");
        button.setFont(Font.font("FontAwesome", 40));
        BorderPane root = new BorderPane();
        final HomeTimeline homeTimeline = new HomeTimeline();
        homeTimeline.refresh();
        root.setCenter(homeTimeline);
        ToolBar toolBar = new ToolBar();
        toolBar.setOrientation(Orientation.VERTICAL);
        toolBar.getItems().add(button);
        root.setLeft(toolBar);
        button.setOnAction(e -> {
            try {
                homeTimeline.refresh();
            } catch (TwitterException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        stage.setScene(new Scene(root, 400, 640));
        stage.setTitle("Tweetalot");
        stage.show();

    }

}
