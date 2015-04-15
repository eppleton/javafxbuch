package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SplitPane splitPane = new SplitPane();
        for (int i = 0; i < 5; i++) {
            splitPane.getItems().add(new StackPane(new Label("Fenster " + i)));
        }
        StackPane pane = new StackPane(splitPane);
        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
