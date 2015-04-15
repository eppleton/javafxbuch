package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HTMLEditor htmlEditor = new HTMLEditor();
        StackPane root = new StackPane();
        root.getChildren().add(htmlEditor);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("HTMLEditor Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
