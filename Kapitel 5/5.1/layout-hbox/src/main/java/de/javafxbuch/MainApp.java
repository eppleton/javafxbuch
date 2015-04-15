package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 20, 20, 20));
        hbox.setSpacing(15);
        Button left = new Button("I'm left");
        Button right = new Button("I'm right");
        hbox.getChildren().addAll(left, right);
        primaryStage.setTitle("You're right: I'm left - she's gone!");
        primaryStage.setScene(new Scene(new StackPane(hbox)));
        primaryStage.show();
    }

}
