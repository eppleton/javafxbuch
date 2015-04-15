package de.javafxbuch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button ok = new Button("OK");
        Button cancel = new Button("Cancel");
        HBox hBox = new HBox(cancel, ok);
        hBox.setBackground(new Background(new BackgroundFill(Color.WHITE.deriveColor(1, 1, 1, .7), CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.setSpacing(10);
        hBox.setVisible(false);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setPadding(new Insets(0, 0, 10, 0));
        EventHandler<ActionEvent> h = e -> {
            hBox.setVisible(!hBox.isVisible());
        };
        ok.setOnAction(h);
        cancel.setOnAction(h);
        Button button = new Button("Do Something!");
        button.setOnAction(h);
        StackPane root = new StackPane(button, hBox);
        primaryStage.setScene(new Scene(root, 300, 200));

        primaryStage.show();
    }

}
