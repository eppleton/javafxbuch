package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TilePane tilePane = new TilePane();
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(i * 3, i * 3);
            rectangle.setFill(new Color(((double) i * 10) / 250,
                    ((double) i * 10) / 250,
                    ((double) i * 10) / 250, 1));
            tilePane.getChildren().add(rectangle);
            TilePane.setAlignment(rectangle, Pos.BOTTOM_RIGHT);
            TilePane.setMargin(rectangle, new Insets(i));
        }
        primaryStage.setScene(new Scene(new StackPane(tilePane), 300, 200));
        // Kein Clipping am Rand:
//        tilePane.setPrefTileHeight(25);
        primaryStage.show();
    }

}
