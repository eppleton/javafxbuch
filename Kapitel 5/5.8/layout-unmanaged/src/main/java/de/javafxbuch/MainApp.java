package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        
        final Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        root.getChildren().add(createChart());
        Label text = new Label("Demo Version\nBuy a License!");
        text.setFont(Font.font("Verdana", 56));
        text.resizeRelocate(60, 60, 450, 200);
        root.getChildren().add(text);
        // Ohne die nächste Zeile übernimmt die VBox das Layouten:
        text.setManaged(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node createChart() {
        NumberAxis xAxis = new NumberAxis("Werte der X-Achse", 0, 3, 1);
        NumberAxis yAxis = new NumberAxis("Werte der Y-Achse", 0, 3, 1);
        ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList(
                new LineChart.Series<Double, Double>("Serie 1", FXCollections.observableArrayList(
                                new XYChart.Data<Double, Double>(0.0, 1.0),
                                new XYChart.Data<Double, Double>(1.2, 1.4),
                                new XYChart.Data<Double, Double>(2.2, 1.9),
                                new XYChart.Data<Double, Double>(2.7, 2.3),
                                new XYChart.Data<Double, Double>(2.9, 0.5)
                        )),
                new LineChart.Series<Double, Double>("Serie 2", FXCollections.observableArrayList(
                                new XYChart.Data<Double, Double>(0.0, 1.6),
                                new XYChart.Data<Double, Double>(0.8, 0.4),
                                new XYChart.Data<Double, Double>(1.4, 2.9),
                                new XYChart.Data<Double, Double>(2.1, 1.3),
                                new XYChart.Data<Double, Double>(2.6, 0.9)
                        ))
        );
        LineChart chart = new LineChart(xAxis, yAxis, lineChartData);
        return chart;
    }

}
