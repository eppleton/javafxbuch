package de.javafxbuch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CounterService counterService = new CounterService(100);
        Button btn = new Button();
        btn.setText("Restart Counting");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counterService.restart();
            }
        });
        counterService.start();
        btn.opacityProperty().bind(counterService.progressProperty());
        btn.scaleXProperty().bind(counterService.progressProperty());
        btn.scaleYProperty().bind(counterService.progressProperty());
        btn.textProperty().bind(counterService.messageProperty());

        primaryStage.setScene(new Scene(new StackPane(btn), 140, 40));
        primaryStage.show();
    }

}
