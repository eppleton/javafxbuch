package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ChoiceBox cb = new ChoiceBox();
        for (int i = 0; i < 20; i++) {
            cb.getItems().add("Option " + i);
        }
        StackPane pane = new StackPane(cb);
        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setTitle(
                "TableView Demo");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
