package de.javafxbuch;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 100, 100);
        StackPane root = new StackPane();
        Button button = new Button("Close");
        root.getChildren().add(button);
        button.setOnAction(e-> Platform.exit());
        Scene scene = new Scene(root, 200, 200);
        root.setShape(circle);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }

   
}
