package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        Text number = new Text("53");
        number.setFont(Font.font("Arial", FontWeight.BOLD, 64));
        StackPane herbie = new StackPane(circle, number);
        primaryStage.setScene(new Scene(herbie, 300, 200));

        primaryStage.show();
    }

}
