package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
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
        Button btn = new Button();
        btn.setText("Run");
        final Task<Integer> task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                int iterationen;
                for (iterationen = 0; iterationen < 100000; iterationen++) {
                    Thread.sleep(100);
                    updateProgress(iterationen, 100000);
                }
                return iterationen;
            }
        };
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.textProperty().bind(
                        Bindings.concat("Progress ",
                                task.progressProperty().multiply(100), "%"));
                Thread thread = new Thread(task);
                thread.start();
            }
        });
        primaryStage.setScene(new Scene(new StackPane(btn)));
        primaryStage.show();
    }

}
