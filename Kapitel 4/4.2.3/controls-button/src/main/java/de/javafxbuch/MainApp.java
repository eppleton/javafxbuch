package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // modifiziertes Beispiel 4.2.1
        Button label = new Button("Hello World!");
        Image image = new Image(getClass().getResourceAsStream("world.png"));
        label.setGraphic(new ImageView(image));
        label.setContentDisplay(ContentDisplay.TOP);
        label.setGraphicTextGap(30);
        label.setText("Ersetzen wir den Text gegen einen längeren Text, " + " ist es sinnvoll, diesen Text bei Bedarf zu umbrechen.");
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER);

        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
