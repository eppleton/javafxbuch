package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        NumberAxis xAxis = new NumberAxis("Zeit", 0, 40, 5);
        NumberAxis yAxis = new NumberAxis("Preis", 0, 80, 10);
        ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList(
                new LineChart.Series<Double, Double>("Orakel", FXCollections.observableArrayList(
                                new XYChart.Data<Double, Double>(0.0, 10.0), new XYChart.Data<Double, Double>(10.0, 34.4), new XYChart.Data<Double, Double>(20.0, 31.9), new XYChart.Data<Double, Double>(30.0, 42.3), new XYChart.Data<Double, Double>(40.0, 57.7)
                        )),
                new LineChart.Series<Double, Double>("Essape",
                        FXCollections.observableArrayList(new XYChart.Data<Double, Double>(0.0, 57.7), new XYChart.Data<Double, Double>(10.0, 42.3), new XYChart.Data<Double, Double>(20.0, 33.9),
                                new XYChart.Data<Double, Double>(30.0, 21.7),
                                new XYChart.Data<Double, Double>(40.0, 17.3)))
        );
        StackedAreaChart chart = new StackedAreaChart(xAxis, yAxis, lineChartData);
        Scene scene = new Scene(chart);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
