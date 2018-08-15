package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainApp extends Application {

    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        webView.setContextMenuEnabled(false);
        WebEngine engine = webView.getEngine();
        engine.load("http://dukescript.com");

        BorderPane borderPane = new BorderPane(webView);
        ProgressBar progressBar = new ProgressBar();
        progressBar.progressProperty().bind(
                engine.getLoadWorker().progressProperty());
        engine.getLoadWorker().stateProperty().addListener((e, o, n) -> {
            if (n == State.SUCCEEDED) {
                progressBar.setVisible(false);
            } else if (n == State.RUNNING) {
                progressBar.setVisible(true);
            }
        });
        StackPane root = new StackPane(borderPane, progressBar);
        Scene scene = new Scene(root, 640, 400);

        MenuBar menuBar = new MenuBar();
        final Menu navigateMenu = new Menu("Navigate");
        MenuItem home = new MenuItem("Home");
        navigateMenu.getItems().addAll(home);
        home.setOnAction(e -> engine.load("http://eppleton.de"));
        Menu historyMenu = new Menu("History");
        engine.getHistory().getEntries().addListener(
                (ListChangeListener.Change<? extends Entry> c) -> {
                    c.next();
                    for (Entry e : c.getAddedSubList()) {
                        for (MenuItem i : historyMenu.getItems()) {
                            if (i.getId().equals(e.getUrl())) {
                                historyMenu.getItems().remove(i);
                            }
                        }
                    }
                    for (Entry e : c.getAddedSubList()) {
                        final MenuItem menuItem = new MenuItem(e.getUrl());
                        menuItem.setId(e.getUrl());
                        menuItem.setOnAction(a -> engine.load(e.getUrl()));
                        historyMenu.getItems().add(menuItem);
                    }
                });
        menuBar.getMenus().addAll(navigateMenu, historyMenu);
        borderPane.setTop(menuBar);
        primaryStage.setTitle("JavaFX WebView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
