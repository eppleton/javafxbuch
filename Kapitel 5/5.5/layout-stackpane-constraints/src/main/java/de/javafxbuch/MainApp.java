package de.javafxbuch;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
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
        Rectangle rect = new Rectangle(100, 100);
        ArrayList<Stop> stops = new ArrayList<Stop>();
        stops.add(new Stop(0, Color.LIGHTGREEN));
        stops.add(new Stop(1, Color.FORESTGREEN));
        rect.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops));
        rect.setStroke(Color.WHITE);
        Text center = new Text("Ba");
        center.setFont(Font.font("Arial", FontWeight.BOLD, 64));
        center.setFill(Color.WHITE);
        Text topRight = new Text("+2");
        topRight.setFont(Font.font("Arial", 8));
        topRight.setFill(Color.WHITE);
        Text topLeft = new Text("137.33");
        topLeft.setFont(Font.font("Arial", 8));
        topLeft.setFill(Color.WHITE);
        Text bottomLeftSmall = new Text("2-8-18-7");
        bottomLeftSmall.setFont(Font.font("Arial", 8));
        bottomLeftSmall.setFill(Color.WHITE);
        Text bottomLeft = new Text("56");
        bottomLeft.setFont(Font.font("Arial", 10));
        bottomLeft.setFill(Color.WHITE);
        StackPane.setAlignment(topRight, Pos.TOP_RIGHT);
        StackPane.setAlignment(topLeft, Pos.TOP_LEFT);
        StackPane.setAlignment(bottomLeft, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(bottomLeftSmall, Pos.BOTTOM_LEFT);
        StackPane.setMargin(bottomLeftSmall, new Insets(0, 0, 2, 4));
        StackPane.setMargin(bottomLeft, new Insets(0, 0, 14, 4));
        StackPane.setMargin(topRight, new Insets(5));
        StackPane.setMargin(topLeft, new Insets(5));
        StackPane barium = new StackPane(rect, center, topRight, topLeft, bottomLeft, bottomLeftSmall);
        barium.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        primaryStage.setScene(new Scene(barium, 100, 100));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}
