package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 5.7.1 Nodes hinzufügen 
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(8);
        gridPane.setPadding(new Insets(10));

        Image image = new Image(getClass().getResource("duke-wave.png").toExternalForm(), 100, 100, true, true);
        final ImageView logo = new ImageView(image);
        gridPane.add(logo, 3, 0);

        Label heading = new Label("This is a GridPane");
        gridPane.add(heading, 0, 0, 3, 1);

        gridPane.add(new Label("Name:"), 1, 1);
        gridPane.add(new TextField("Name eingeben"), 2, 1);
        gridPane.add(new Label("Beruf:"), 1, 2);
        gridPane.add(new TextField("Beruf eingeben"), 2, 2);
        gridPane.add(new Button("speichern"), 3, 4);

        gridPane.setGridLinesVisible(true);

// 5.7.2 
        gridPane.getRowConstraints().add(0, new RowConstraints(40));

        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(25);
        gridPane.getColumnConstraints().addAll(new ColumnConstraints(), cc);
        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(new ColumnConstraints(), cc, cc2);
// 5.7.3 
        GridPane.setHalignment(logo, HPos.RIGHT);
        GridPane.setValignment(logo, VPos.TOP);
        GridPane.setHalignment(heading, HPos.LEFT);
        GridPane.setValignment(heading, VPos.TOP);

        Scene scene = new Scene(gridPane, 400,160);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
