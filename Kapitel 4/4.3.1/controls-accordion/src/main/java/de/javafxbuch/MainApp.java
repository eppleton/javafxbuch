package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TitledPane circlePane = new TitledPane("Circle", new Circle(50));
        TitledPane rectanglePane = new TitledPane("Rectangle", new Rectangle(100, 100));
        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(circlePane, rectanglePane);
        StackPane pane = new StackPane(accordion);
        Scene scene = new Scene(pane, 300, 250);

 
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
