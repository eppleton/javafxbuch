package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
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
        double SCALING_FACTOR = 2.5;
        final NumberAxis xAxis = new NumberAxis("Entfernug zur Sonne", 0, 5000,
                500);
        final NumberAxis yAxis = new NumberAxis("Einwohnerzahl (Millionen)",
                -500, 7000, 1000);
        final BubbleChart<Number, Number> blc = new BubbleChart<Number, Number>(xAxis, yAxis);
        XYChart.Series merkur = new XYChart.Series("Merkur", FXCollections.observableArrayList(new XYChart.Data(58, 0,
                4.8 * SCALING_FACTOR)));
        XYChart.Series venus = new XYChart.Series("Venus",
                FXCollections.observableArrayList(new XYChart.Data(108, 0, 12.4 * SCALING_FACTOR)));
        XYChart.Series erde = new XYChart.Series("Erde", FXCollections.observableArrayList(new XYChart.Data(150, 6800,
                12.7 * SCALING_FACTOR)));
        XYChart.Series mars = new XYChart.Series("Mars",
                FXCollections.observableArrayList(new XYChart.Data(280, 0, 6.8 * SCALING_FACTOR)));
        XYChart.Series jupiter = new XYChart.Series("Jupiter", FXCollections.observableArrayList(new XYChart.Data(775, 0,
                142.8 * SCALING_FACTOR)));
        XYChart.Series saturn = new XYChart.Series("Saturn",
                FXCollections.observableArrayList(new XYChart.Data(1440, 0, 120.8 * SCALING_FACTOR)));
        XYChart.Series uranus = new XYChart.Series("Uranus", FXCollections.observableArrayList(new XYChart.Data(2870, 0,
                47.6 * SCALING_FACTOR)));
        XYChart.Series neptun = new XYChart.Series("Neptun",
                FXCollections.observableArrayList(new XYChart.Data(4500, 0, 44.6 * SCALING_FACTOR)));
        blc.getData().addAll(merkur, venus, erde, mars, jupiter, saturn, uranus, neptun);
        return blc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}
