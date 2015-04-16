package de.javafxbuch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox add = createWithBlendMode(BlendMode.ADD, "ADD");
        VBox multiply = createWithBlendMode(BlendMode.MULTIPLY,
                "MULTIPLY");
        VBox difference = createWithBlendMode(
                BlendMode.DIFFERENCE, "DIFFERENCE");
        VBox screen = createWithBlendMode(BlendMode.SCREEN,
                "SCREEN");
        VBox colorburn = createWithBlendMode(
                BlendMode.COLOR_BURN, "COLOR_BURN");
        VBox sourceover = createWithBlendMode(BlendMode.SRC_OVER,
                "SRC_OVER");
        VBox softlight = createWithBlendMode(BlendMode.SOFT_LIGHT,
                "SOFT_LIGHT");
        VBox overlay = createWithBlendMode(BlendMode.OVERLAY,
                "OVERLAY");
        TilePane tilePane = new TilePane(add, multiply, difference, colorburn, screen, sourceover, softlight, overlay);
        Scene scene = new Scene(tilePane, 300, 250);
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
