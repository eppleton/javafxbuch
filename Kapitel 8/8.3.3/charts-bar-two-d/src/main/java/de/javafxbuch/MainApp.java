package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,
                null, " parsecs"));
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                "BubbleTrouble", "Kessel-Run"));
        xAxis.setTickMarkVisible(false);
        yAxis.setLabel("Performance (less is better)");
        ObservableList<XYChart.Series<String, Number>> data
                = FXCollections.observableArrayList(
                        new XYChart.Series<String, Number>("JavaFX",
                                FXCollections.observableArrayList(
                                        new XYChart.Data<String, Number>("BubbleTrouble",
                                                17, 9),
                                        new XYChart.Data<String, Number>("Kessel-Run",
                                                11, 87))),
                        new XYChart.Series<String, Number>("Swing",
                                FXCollections.observableArrayList(
                                        new XYChart.Data<String, Number>("BubbleTrouble", 29, 1),
                                        new XYChart.Data<String, Number>("Kessel-Run", 33, 2))),
                        new XYChart.Series<String, Number>("JavaScript", FXCollections.observableArrayList(
                                        new XYChart.Data<String, Number>("BubbleTrouble", 100),
                                        new XYChart.Data<String, Number>("Kessel-Run", 112))));
        bc.setData(data);
        return bc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}
