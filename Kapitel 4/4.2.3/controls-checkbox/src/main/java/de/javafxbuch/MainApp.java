package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        CheckBox checkBox = new CheckBox("I'm undecided");
        checkBox.setAllowIndeterminate(true);
        checkBox.setIndeterminate(false);
        checkBox.setOnAction(e -> {
            if (checkBox.isIndeterminate()) {
                checkBox.setText("I'm undecided");
            }
            else if (checkBox.isSelected()) {
                checkBox.setText("I agree");
            }
            else if (!checkBox.isSelected()) {
                checkBox.setText("I disagree");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(checkBox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
