package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Datei");
        MenuItem openProjectMenuItem = new MenuItem(
                "Projekt öffnen...");
        fileMenu.getItems().add(openProjectMenuItem);
        Menu helpMenu = new Menu("Hilfe");
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        root.setTop(menuBar);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("MenuBar Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
