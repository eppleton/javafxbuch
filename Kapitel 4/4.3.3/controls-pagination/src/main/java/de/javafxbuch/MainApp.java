package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pagination pagination = new Pagination(10, 0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer i) {
                return new StackPane(new ImageView("http://assets.pokemon.com/assets/cms2/img/pokedex/full/"
                		+ String.format("%03d", i+1)
                        + ".png"));
            }
        });
        StackPane pane = new StackPane(pagination);
        Scene scene = new Scene(pane, 550, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
