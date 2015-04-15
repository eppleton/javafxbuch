package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }
        private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(createChart());
    }

    protected PieChart createChart() {
        PieChart pieChart = new PieChart(FXCollections.observableArrayList(
            new PieChart.Data("Java", 19),
            new PieChart.Data("C", 16),
            new PieChart.Data("C++", 9),
            new PieChart.Data("PHP", 7),
            new PieChart.Data("C#", 6),
            new PieChart.Data("Visual Basic", 5),
            new PieChart.Data("Python", 5),
            new PieChart.Data("Other", 33)
        ));
        pieChart.setId("BasicPie");
        pieChart.setTitle("TIOBE Index");
        return pieChart ;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}
