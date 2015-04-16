package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.ScheduledService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
        counterService.setRestartOnFailure(true); 
        counterService.setMaximumFailureCount(3);
        counterService.setBackoffStrategy( ScheduledService .EXPONENTIAL_BACKOFF_STRATEGY );
        counterService.start();
        btn.opacityProperty().bind(counterService.progressProperty());
        btn.scaleXProperty().bind(counterService.progressProperty());
        btn.scaleYProperty().bind(counterService.progressProperty());
        btn.textProperty().bind(counterService.messageProperty());
        Label label = new Label();
        label.textProperty().bind(Bindings.concat("Value: ",
                counterService.valueProperty()));
        Label label2 = new Label();
        label2.textProperty().bind(Bindings.concat("Last Value: ",
                counterService.lastValueProperty()));
        VBox vBox = new VBox(btn, label, label2);

        primaryStage.setScene(new Scene(vBox, 140, 80));
        primaryStage.show();
    }

}
