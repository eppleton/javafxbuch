/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import java.util.HashMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author antonepple
 */
public class ValueAtBinding extends Application {

    @Override
    public void start(Stage primaryStage) {
        HashMap<String, Double> values = new HashMap<>();
        values.put("give you up", 20.0);
        values.put("let you down", 10.0);
        values.put("turn around and desert you", 27.0);
        values.put("make you cry", 11.0);
        values.put("say goodbye", 19.0);
        values.put("tell a lie and hurt you", 7.0);

        ObservableMap<String, Double> observableMap = FXCollections.observableMap(values);
        SimpleBarChart simpleBarChart = new SimpleBarChart(observableMap);
        VBox root = new VBox( new Label("Rick Astley would never..."), simpleBarChart);
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("valueAt Binding!");
        primaryStage.setScene(scene);
        System.out.println("You have been Rick rolled!");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
