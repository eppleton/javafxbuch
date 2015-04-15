package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
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
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        ScatterChart<Number, Number> sc
                = new ScatterChart<Number, Number>(xAxis, yAxis);
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        for (int s = 1; s < 5; s++) {
            XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
            series.setName("Data Series " + s);
            for (int i = 0; i < 30; i++) {
                series.getData().add(
                        new XYChart.Data<Number, Number>(
                                s % 2 == 0 ? 50 + (Math.random() * 98) / s
                                        : (Math.random() * 98) / s,
                                s % 2 == 0 ? 50 + (Math.random() * 98) / s
                                        : (Math.random() * 98) / s));
            }
                sc.getData().add(series);
        }
        return sc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}
