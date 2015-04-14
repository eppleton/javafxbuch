package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello World!");

        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        Stage stage = new Stage();
        stage.setTitle("Dialog");
        stage.setScene(new Scene(new StackPane(new Label("Bitte beachten: seit JDK 8 u40 gibt es auch eine Dialogs API!"))));
        stage.initOwner(primaryStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

}
