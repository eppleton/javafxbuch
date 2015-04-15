package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SplitPane splitPane = new SplitPane();
        final StackPane stackPane = new StackPane(new Label("Hilfsfenster1"));
        SplitPane.setResizableWithParent(stackPane, false);
        splitPane.getItems().add(stackPane);
        splitPane.getItems().add(new StackPane(new Label("Dokumentenfenster")));
        final StackPane stackPane1 = new StackPane(new Label("Hilfsfenster2"));
        SplitPane.setResizableWithParent(stackPane1, false);
        splitPane.getItems().add(stackPane1);
        StackPane pane = new StackPane(splitPane);
        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
