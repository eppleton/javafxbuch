package de.javafxbuch;

import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Eins", "Zwei", "Drei", "Vier");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String o, String n) -> {
            System.out.println("Vom User selektiert: " + n);
        });
        listView.getSelectionModel().getSelectedItems().addListener((ListChangeListener.Change<? extends String> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    List<? extends String> asl = c.getAddedSubList();
                    asl.stream().forEach((s) -> {
                        System.out.println("Neu selektiert " + s);
                    });
                }
                if (c.wasRemoved()) {
                    List<? extends String> removed = c.getRemoved();
                    removed.stream().forEach((s) -> {
                        System.out.println("Nicht mehr selektiert " + s);
                    });
                }
            }
        });
        StackPane root = new StackPane(listView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("ListView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
