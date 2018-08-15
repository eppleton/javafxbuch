package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
        ImageView imageView = new ImageView(new Image(getClass().getResource("javaduke_html5.png").toExternalForm()));
        root.setCenter(imageView);
        ContextMenu contextMenu = new ContextMenu();
        MenuItem halloMenuItem = new MenuItem("Sag 'Hallo'");
        halloMenuItem.setOnAction(
                e -> System.out.println("Duke: 'Hallo!'"));
        contextMenu.getItems().add(halloMenuItem);
        imageView.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(imageView, e.getScreenX(), e.getScreenY());
            }
        });
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("MenuBar Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
