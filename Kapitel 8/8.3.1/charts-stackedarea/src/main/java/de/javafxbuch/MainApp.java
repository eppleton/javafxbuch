package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        NumberAxis xAxis = new NumberAxis("Zeit", 1981, 1985, 1);
        NumberAxis yAxis = new NumberAxis("Verkaufte Einheiten", 0, 160, 10);
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,null,"k"));
        ObservableList<XYChart.Series<Integer, Double>> lineChartData = FXCollections.observableArrayList(
                new LineChart.Series<Integer, Double>("C64", FXCollections.observableArrayList(
                                new XYChart.Data<Integer, Double>(1981, 0.0),
                                new XYChart.Data<Integer, Double>(1982, 10.0),
                                new XYChart.Data<Integer, Double>(1983, 34.4),
                                new XYChart.Data<Integer, Double>(1984, 31.9),
                                new XYChart.Data<Integer, Double>(1985, 42.3)
                        )),
                new LineChart.Series<Integer, Double>("ZX Spectrum", FXCollections.observableArrayList(
                                new XYChart.Data<Integer, Double>(1981, 0.0),
                                new XYChart.Data<Integer, Double>(1982, 57.7),
                                new XYChart.Data<Integer, Double>(1983, 42.3),
                                new XYChart.Data<Integer, Double>(1984, 33.9),
                                new XYChart.Data<Integer, Double>(1985, 21.7)
                        )),
                new LineChart.Series<Integer, Double>("CPC464", FXCollections.observableArrayList(
                                new XYChart.Data<Integer, Double>(1981, 0.0),
                                new XYChart.Data<Integer, Double>(1982, 0.0),
                                new XYChart.Data<Integer, Double>(1983, 0.0),
                                new XYChart.Data<Integer, Double>(1984, 20.0),
                                new XYChart.Data<Integer, Double>(1985, 40.0) 
                )),
                new LineChart.Series<Integer, Double>("Andere", FXCollections.observableArrayList(
                                new XYChart.Data<Integer, Double>(1981, 10.0),
                                new XYChart.Data<Integer, Double>(1982, 15.0),
                                new XYChart.Data<Integer, Double>(1983, 13.0),
                                new XYChart.Data<Integer, Double>(1984, 11.0),
                                new XYChart.Data<Integer, Double>(1985, 14.0) 
                ))
        );
        StackedAreaChart chart = new StackedAreaChart(xAxis, yAxis, lineChartData);
        chart.setTitle("Heimcomputer-Verkaufszahlen in Deutschland");
        root.getChildren().add(chart);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

}
