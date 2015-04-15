package de.javafxbuch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<Double> listView = new ListView<>();
        listView.getItems().addAll(52.4, 1.7, -17.0);
        listView.setCellFactory(new Callback<ListView<Double>, ListCell<Double>>() {

            @Override
            public ListCell<Double> call(ListView<Double> param) {
                return new DoubleListCell();
            }
        });
        listView.setEditable(true);
        StackPane root = new StackPane(listView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("ListView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class DoubleTextField extends TextField {

        @Override
        public void replaceText(int start, int end, String text) {
            if (validate(createPreview(start, end, text))) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text) {
            final int dot = getCaretPosition();
            final int mark = getAnchor();
            int start = Math.min(dot, mark);
            int end = Math.max(dot, mark);
            if (validate(createPreview(start, end, text))) {
                super.replaceSelection(text);
            }
        }

        private boolean validate(String text) {
            if (text.matches("[-+]?[0-9]*\\.?[0-9]+") || text == "") {
                System.out.println("ok");
                return true;
            }
            System.out.println("Nan");
            return false;
        }

        private String createPreview(int start, int end, String text) {
            String get = getContent().get(0, start);
            String preview = get.concat(text);
            if (end < getContent().length()) {
                preview = preview.concat(getContent().get(end, getContent().length()));
            }
            return preview;
        }
    }

    private static class DoubleListCell extends ListCell<Double> {

        DoubleTextField dtf = new DoubleTextField();

        public DoubleListCell() {
            dtf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    commitEdit(Double.parseDouble(dtf.getText()));
                }
            });
        }

        @Override
        protected void updateItem(Double item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null & !empty) {
                dtf.setText(item.toString());
                if (!isEditing()) {
                    setText(item.toString());
                }
            } else {
                setText("");
                setGraphic(null);
            }
        }

        @Override
        public void startEdit() {
            setText("");
            super.startEdit();
            dtf.setEditable(true);
            setGraphic(dtf);
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setGraphic(null);
        }
    }

}
