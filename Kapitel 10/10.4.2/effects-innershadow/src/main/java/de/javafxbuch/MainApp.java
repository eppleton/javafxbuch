package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        InnerShadow innerShadow = new InnerShadow(BlurType.GAUSSIAN,
                Color.GRAY,
                10, 0, 4, 1);
        Text text = new Text("Inner\nShadow");
        text.setEffect(innerShadow);
        text.setFill(Color.WHITE);
        text.setFont(Font.font(null, FontWeight.BOLD, 100));
        Scene scene = new Scene(new StackPane(text), 600, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
