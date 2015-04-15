package de.javafxbuch;

import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SplitPaneDemo extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    private SplitPane splitPane;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        Preferences prefs = Preferences.userNodeForPackage(SplitPaneDemo.class);
        splitPane = new SplitPane();

        if (prefs.getDouble("divider0", -1) != -1) {
            for (int i = 0; i < splitPane.getDividerPositions().length; i++) {
                splitPane.setDividerPosition(i,
                        prefs.getDouble("divider" + i, 0));
            }
        }
        for (int i = 0; i < 5; i++) {
            StackPane stackPane = new StackPane(new Label("Fenster " + i));
            stackPane.setMinWidth(40);
            stackPane.setMaxWidth(120);
            splitPane.getItems().add(stackPane);
        }
//        SplitPane vSplitPane = new SplitPane();
//        vSplitPane.setOrientation(Orientation.VERTICAL);
//        for (int i = 6; i < 8; i++) {
//            vSplitPane.getItems().add(new StackPane(new Label("Fenster " + i)));
//        }
//        splitPane.getItems().add(vSplitPane);
        scene = new Scene(splitPane, prefs.getDouble("width", 300), prefs.getDouble("height", 250));
        primaryStage.setX(prefs.getDouble("x", 100));
        primaryStage.setY(prefs.getDouble("y", 100));
        primaryStage.setTitle("SplitPane Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        double[] dividerPositions = splitPane.getDividerPositions();
        Preferences prefs = Preferences.userNodeForPackage(
                SplitPaneDemo.class);
        for (int i = 0; i < dividerPositions.length; i++) {
            double d = dividerPositions[i];
            prefs.putDouble("divider" + i, d);
        }
        prefs.putDouble("width", scene.getWidth());
        prefs.putDouble("height", scene.getHeight());
        prefs.putDouble("x", scene.getWindow().getX());
        prefs.putDouble("y", scene.getWindow().getY());
    }
}
