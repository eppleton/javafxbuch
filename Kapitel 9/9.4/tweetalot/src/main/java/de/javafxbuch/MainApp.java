package de.javafxbuch;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import twitter4j.TwitterException;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Font.loadFont(getClass().getResource("fontawesome-webfont.ttf").
                toExternalForm(), 12);
        Button button = new Button("\uf015");
        button.getStyleClass().add("view-button");
        button.setFont(Font.font("FontAwesome", 40));
        BorderPane root = new BorderPane();
        final HomeTimeline homeTimeline = new HomeTimeline();
//        homeTimeline.refresh();
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
        Scene scene = new Scene(root, 400, 640);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Tweetalot");
        stage.show();

    }

}
