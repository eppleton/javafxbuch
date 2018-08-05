package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

    protected Chart createChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        xAxis.setCategories(FXCollections.<String>observableArrayList(""));
        xAxis.setTickMarkVisible(false);
        yAxis.setLabel("Performance");
        XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>("JavaFX", FXCollections.observableArrayList(new XYChart.Data<String, Number>("",
                956)));
        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>("Swing", FXCollections.observableArrayList(new XYChart.Data<String, Number>("", 789)));
        XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>("JavaScript",
                FXCollections.observableArrayList(new XYChart.Data<String, Number>("", 312)));
        bc.getData().addAll(series1, series2, series3);

        return bc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}
