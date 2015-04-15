package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<Double> listView = new ListView<>();
        listView.getItems().addAll(52.4, 1.7, -17.0);
        listView.setCellFactory((param) -> {
            return new TemperatureCell();
        });
        listView.setEditable(true);
        StackPane root = new StackPane(listView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("ListView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class TemperatureCell extends ListCell<Double> {

        private Circle circle = new Circle(10);
        private Slider slider = new Slider(-100, 100, 0);

        @Override
        public void startEdit() {
            super.startEdit();
            setGraphic(slider);
        }

        public TemperatureCell() {
            slider.valueChangingProperty().addListener((observable,
                    oldValue, newValue) -> {
                        if (!newValue) {
                            commitEdit(slider.getValue());
                        }
                    });
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setGraphic(circle);
        }

        @Override
        protected void updateItem(Double item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null & !empty) {
                slider.setValue(item);
                textProperty().bind(Bindings.concat(slider.valueProperty(),
                        "°C"));
                textFillProperty().bind(new ObjectBinding<Paint>() {
                    {
                        super.bind(slider.valueProperty());
                    }

                    @Override
                    protected Paint computeValue() {
                        return slider.getValue() < 0 ? Color.BLUE : slider.getValue() > 21
                                ? Color.RED : Color.BLACK;
                    }
                });
                if (!isEditing()) {
                    circle.setFill(item < 0 ? Color.BLUE : item > 21
                            ? Color.RED : Color.BLACK);
                    setGraphic(circle);
                }
            } else {
                textProperty().unbind();
                setText("");
                setGraphic(null);
            }
        }

    }
}
