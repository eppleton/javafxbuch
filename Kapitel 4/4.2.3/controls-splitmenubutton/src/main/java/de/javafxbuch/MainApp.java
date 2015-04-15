package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SplitMenuButton m = new SplitMenuButton();
        m.setText("Kartoffelsalat");
        m.setPopupSide(Side.RIGHT);
        m.setOnAction(e -> System.out.println("Ich mag Kartoffelsalat"));
        MenuItem menuItem = new MenuItem("Bayerische Art");
        menuItem.setOnAction(e -> System.out.println(
                "Ich mag ihn auf bayerische Art "));
        MenuItem menuItem1 = new MenuItem("Rheinische Art");
        menuItem1.setOnAction(e -> System.out.println(
        "Ich mag ihn  auf rheinische Art ")); 
        m.getItems().addAll(menuItem, menuItem1);
        StackPane root = new StackPane(m);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
