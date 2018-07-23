package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MyBean myBean = new MyBean();
        myBean.setSample("Hallo");

        // Ein Listener, der den neuen Wert auf System.out ausgibt
        myBean.sampleProperty().addListener((obs, o, n) -> System.out.println("neuer Wert: " + n));
        
        // Der Button setzt einen neuen Wert
        Button button = new Button("Wert aendern!");
        button.setOnAction(e -> myBean.setSample("Anderer Wert!"));

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
