package de.javafxbuch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

    int i = 0;

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
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        lineChart.setCreateSymbols(false);
        lineChart.setAnimated(false);
        xAxis.setForceZeroInRange(false);
        final XYChart.Series<Number, Number> dataSeries = new XYChart.Series<Number, Number>();
        lineChart.getData().add(dataSeries);
        Timeline animation = new Timeline();
        animation.getKeyFrames()
                .add(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        dataSeries.getData().add(new XYChart.Data<Number, Number>(i++, Math.random() * 100));
                        if (dataSeries.getData().size() > 30) {
                            dataSeries.getData().remove(0);
                        }
                    }
                }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        return lineChart;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
}
