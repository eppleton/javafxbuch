package de.javafxbuch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        final CustomRegion customRegion = new CustomRegion();
        customRegion.getStyleClass().add("my");
        Button btn = new Button();
        btn.setText("Change active state!");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                customRegion.setActive(!customRegion.isActive());
            }
        });

        StackPane root = new StackPane(customRegion, btn);
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass()
                .getResource("pseudo.css").toExternalForm());
        primaryStage.setTitle("Custom Pseudoclass!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
