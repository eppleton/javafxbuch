package de.javafxbuch;

import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author antonepple
 */
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "ace", "jack", "king", "queen"};
        String[] colors = {"clubs", "diamonds", "hearts", "spades"};
        EventHandler<MouseEvent> clickHandler;
        final CardStackLayout cardStackLayout = new CardStackLayout();
        final CardStackLayout cardStackLayout2 = new CardStackLayout();
        clickHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Node source = (Node) event.getSource();
                Parent parent = source.getParent();
                if (parent == cardStackLayout) {
                    cardStackLayout.getChildren().remove(source);
                    cardStackLayout2.getChildren().add(source);
                }
                if (parent == cardStackLayout2) {
                    cardStackLayout2.getChildren().remove(source);
                    cardStackLayout.getChildren().add(source);
                }

            }
        };
        for (int i = 0; i < colors.length; i++) {
            String color = colors[i];
            for (int j = 0; j < values.length; j++) {
                String value = values[j];
                String rn = "cards/" + value + "_of_" + color + ".png";
                Image image = new Image(getClass().getResource(rn).toExternalForm(), 200, 200, true, false);
                ImageView card = new ImageView(image);
                card.setOnMouseClicked(clickHandler);
                cardStackLayout.getChildren().add(card);
            }
        }
        VBox vBox = new VBox(cardStackLayout, cardStackLayout2);
        vBox.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(vBox, 644, 400);

        primaryStage.setTitle("Custom layout Demo!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
