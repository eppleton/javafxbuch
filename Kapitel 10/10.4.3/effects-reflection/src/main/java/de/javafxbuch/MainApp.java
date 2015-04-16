package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        Text text = new Text();
        text.setText("Effekt bitte nicht mehr verwenden!");
        text.setFill(Color.GREY);
        text.setFont(new Font(30));
        text.setEffect(reflection);
        Scene scene = new Scene(new StackPane(text), 600, 250);
        primaryStage.setTitle("Blend Effects Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createWithBlendMode(BlendMode mode, String title) {
        ImageView i1 = new ImageView(getClass().
                getResource("javaduke_html5.png").toExternalForm());
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 1,
                true, CycleMethod.NO_CYCLE, new Stop(0, Color.BLACK),
                new Stop(1, Color.AQUA));
        Blend blend = new Blend(mode);
        blend.setBottomInput(new ColorInput(0, 0, 250, 250,
                linearGradient));
        Group g = new Group(i1);
        g.setEffect(blend);
        VBox result = new VBox(10, g, new Text(title));
        result.setAlignment(Pos.CENTER);
        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
