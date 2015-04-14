package de.javafxbuch;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello World!");

        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        Parameters p = getParameters();
        List<String> raw = p.getRaw();
        for (String string : raw) {
            System.out.println("HelloWorld Parameter: " + string);
        }

        Map<String, String> named = p.getNamed();
        Set<String> keySet = named.keySet();
        for (String key : keySet) {
            System.out.println("HelloWorld Parameter: " + key + " Wert: "
                    + named.get(key));
        }

        List<String> unnamed = p.getUnnamed();
        for (String param : unnamed) {
            System.out.println("Unnamed Parameter " + param);
        }

    }

}
