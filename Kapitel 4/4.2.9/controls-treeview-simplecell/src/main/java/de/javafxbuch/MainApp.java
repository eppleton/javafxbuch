package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TreeView treeView = new TreeView();
        TreeItem<Color> root = new TreeItem<>(Color.RED);
        treeView.setRoot(root);
        treeView.setEditable(true);
        treeView.setCellFactory(TextFieldTreeCell.forTreeView(new StringConverter<Color>() {
            @Override
            public String toString(Color object) {
                return object.toString();
            }

            @Override
            public Color fromString(String string) {
                Color web = Color.BLACK;
                try {
                    web = Color.web(string);
                } catch (Exception e) {
                    // im Fehlerfall geben wir Schwarz als Farbe zurueck 
                }
                return web;
            }
        }
        ));
		root.getChildren().add(new TreeItem<Color>(Color.BLUE));
        StackPane pane = new StackPane(treeView);
        Scene scene = new Scene(pane, 300, 250);

		primaryStage.setTitle("TableView Demo");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
