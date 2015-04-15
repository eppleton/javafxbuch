package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> cb = new ComboBox<>();
        cb.setPromptText("Option wählen");
        cb.setEditable(true);
        cb.getItems().addAll("Option 1", "Option 2", "Option 3");
//        cb.setVisibleRowCount(2);

        StackPane pane = new StackPane(cb);
        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
