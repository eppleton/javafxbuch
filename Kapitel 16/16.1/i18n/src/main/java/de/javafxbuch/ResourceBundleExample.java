package de.javafxbuch;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author antonepple
 */
public class ResourceBundleExample extends Application {
    
     
    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.FRENCH);
        ResourceBundle bundle = ResourceBundle.getBundle("de/javafxbuch/bundle");
    
        Button btn = new Button();
        btn.setText(bundle.getString("hello_world_button_text"));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println(bundle.getString("hello_world_message"));
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);   
        primaryStage.setTitle(bundle.getString("hello_world_title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
