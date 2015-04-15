package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Hyperlink hyperlink = new Hyperlink("www.klickmich.de");
        hyperlink.setOnAction(e -> hyperlink.setText("www.schongeklickt.de"));
        StackPane root = new StackPane();
        root.getChildren().add(hyperlink);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
