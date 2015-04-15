package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Dummy Button");
        btn.setTooltip(new Tooltip("Dieser Button tut nichts."));
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Tooltip tooltip = new Tooltip("Ein ToolTip für die StackPane");
        Tooltip.install(root, tooltip);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Tooltip Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
