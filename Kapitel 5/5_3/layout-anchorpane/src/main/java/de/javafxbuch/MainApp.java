package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        Button save = new Button("save");
        Button help = new Button("help");
        Button cancel = new Button("cancel");
        HBox buttons = new HBox();
        buttons.setSpacing(12);
        buttons.getChildren().addAll(cancel, save, help);
        anchorPane.getChildren().add(buttons);
        AnchorPane.setRightAnchor(buttons, 10.0);
        AnchorPane.setBottomAnchor(buttons, 20.0);
        primaryStage.setScene(new Scene(new StackPane(anchorPane), 300, 200));

        primaryStage.show();
    }

}
