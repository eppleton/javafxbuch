package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        MyBean myBean = new MyBean();
        myBean.setSample("Ausgangswert");
        
        Label label = new Label();
        label.textProperty().bind(myBean.sampleProperty());
        
        TextField textField = new TextField();
        myBean.sampleProperty().bind(textField.textProperty());
        
        VBox root = new VBox(textField, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400,400);
        primaryStage.setTitle("binding");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
