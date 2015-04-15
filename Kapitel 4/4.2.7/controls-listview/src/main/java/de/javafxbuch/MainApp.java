package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
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
        
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String o, String n) -> {
            System.out.println("Vom User selektiert: " + n);
        });
        StackPane root = new StackPane(listView);
        Scene scene = new Scene(root);
        primaryStage.setTitle("ListView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
