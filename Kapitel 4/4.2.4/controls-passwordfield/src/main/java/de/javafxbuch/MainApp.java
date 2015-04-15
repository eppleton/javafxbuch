package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PasswordField passwordField = new PasswordField();
// Die Eingabeaufforderung wird nur angezeigt, wenn die
// Komponente *nicht* den Eingabefokus hat. (In diesem Beispiel 
// daher nicht sichtbar)
        passwordField.setPromptText("Bitte Passwort eingeben!");
        passwordField.setOnAction(e
                -> System.out.println(passwordField.getText()));
        StackPane root = new StackPane();
        root.getChildren().add(passwordField);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("PasswordField Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
