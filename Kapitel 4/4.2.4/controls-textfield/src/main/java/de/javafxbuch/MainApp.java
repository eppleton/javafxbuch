package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) {
        TextField textField = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                if (text.matches("[0-9]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (text.matches("[0-9]")) {
                    super.replaceSelection(text);
                }
            }
        };
        textField.setPromptText("Bitte hier etwas eingeben...");
        textField.setOnAction(e
                -> System.out.println("Eingabe: " + textField.getText()));
        VBox root = new VBox();
        root.getChildren().add(textField);
        root.getChildren().add(new Button("Dummy"));
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("TextField Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
