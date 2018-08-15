package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) {
		ColorPicker colorPicker = new ColorPicker();
		colorPicker.setOnAction(e -> System.out.println("Farbe " + colorPicker.getValue()));
		StackPane pane = new StackPane(colorPicker);
		Scene scene = new Scene(pane, 300, 250);

		primaryStage.setScene(scene);

		primaryStage.show();
    }

}
