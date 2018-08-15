package de.javafxbuch.tweetalot;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        RequestToken requestToken = twitter.getOAuthRequestToken();
		Font.loadFont(getClass().getResource("fontawesome-webfont.ttf").toExternalForm(), 12);
        root = new BorderPane();
        StackPane stackPane = new StackPane(root);
        final WebView webView = new WebView();
        final WebEngine engine = webView.getEngine();
        engine.load(requestToken.getAuthorizationURL());
        webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {

            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if (newValue == State.SUCCEEDED) {
                    Document document = engine.getDocument();
                    NodeList codeEls = document.getElementsByTagName("code");
                    for (int i = 0; i < codeEls.getLength(); i++) {
                        Node item = codeEls.item(i);
                        String pin = item.getTextContent();
                        AccessToken accessToken = null;
                        try {
                            if (pin.length() > 0) {
                                accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                            } else {
                                accessToken = twitter.getOAuthAccessToken();
                            }
                        } catch (TwitterException ex) {
                            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (pin != null) {
                            Platform.runLater(() -> {
                                stackPane.getChildren().remove(webView);
                                activateTimeline();
                            });
                        }
                    }

                }

            }

        });
        stackPane.getChildren().add(webView);
        Scene scene = new Scene(stackPane, 400, 640);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Tweetalot");

        stage.show();
    }
    private BorderPane root;

    private void activateTimeline() {
        try {
            Button button = new Button("\uf015");
            button.setFont(Font.font("FontAwesome", 40));
            button.getStyleClass().add("view-button");

            ToolBar toolBar = new ToolBar();
            toolBar.setOrientation(Orientation.VERTICAL);
            toolBar.getItems().add(button);
            root.setLeft(toolBar);
            final HomeTimeline homeTimeline = new HomeTimeline();
            homeTimeline.refresh();
            root.setCenter(homeTimeline);
            button.setOnAction(e -> {
                try {
                    homeTimeline.refresh();
                } catch (TwitterException ex) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (TwitterException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
