package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class WebViewForms extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        final WebEngine engine = webView.getEngine();
        engine.load(WebViewForms.class
                .getResource("form.html").toExternalForm());
        engine.getLoadWorker().stateProperty()
                .addListener(new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                                JSObject script
                                = (JSObject) engine.executeScript("window");
                                script.setMember("formValues",
                                        new ValuePrinter());
                            }
                });
        Scene scene = new Scene(webView, 600, 250);
        primaryStage.setTitle("JavaFX WebView Callback Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
