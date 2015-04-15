package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(8); // spacing ist 8
        Button claimExcessSpace = new Button("lass mich wachsen!");
        claimExcessSpace.setMaxHeight(1000);
        VBox.setVgrow(claimExcessSpace, Priority.ALWAYS);
        Button staySmall = new Button("lass mich in Ruhe!");
        staySmall.setMaxHeight(1000);
        vbox.getChildren().addAll(claimExcessSpace, staySmall);
        primaryStage.setScene(new Scene(new StackPane(vbox)));
        primaryStage.show();
    }

}
