package de.javafxbuch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MyBean myBean = new MyBean();
        myBean.setSample("Hallo");
        System.out.println(myBean.getSample());
        // erst in der nächsten Zeile wird die Property erzeugt:
        myBean.sampleProperty().addListener(e -> System.out.println(myBean.getSample()));
        Platform.exit();
    }

}
