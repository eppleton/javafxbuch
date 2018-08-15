package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M48.859,43.518c8.424,17.64,2.736,140.832-7.128,184.032\n" +
"	c-9.864,43.272-19.728,98.28-22.032,144.576c-1.008,19.728,2.016,27.504,14.904,27.504c22.752,0,51.624-47.952,87.84-46.872\n" +
"	c36.288,1.08,47.808,55.008,64.8,54.648c16.992-0.36,30.672-6.264,30.816-58.752C218.563,191.981,87.235,64.973,48.859,43.518\n" +
"	L48.859,43.518L48.859,43.518L48.859,43.518z");
        SVGPath svgPath1 = new SVGPath();
        svgPath1.setContent("M162.763,168.726c7.992,13.464,28.368,3.096,29.232-12.096\n" +
"	c0.864-15.192-1.368-34.344-11.232-35.064c-9.864-0.72-16.92-10.584-26.784-11.304c-9.864-0.72-20.448,9.144-25.056-3.96\n" +
"	s12.384-18.648,25.056-20.736c-11.304-11.304-17.928-23.832-22.896-36.864c-4.968-13.032-8.64-24.984,5.256-30.096\n" +
"	c13.896-5.112,12.744,21.168,28.656,33.192c-4.68-17.712-6.408-25.056-6.048-35.352s-0.36-18.144,14.256-16.128\n" +
"	c14.616,2.016,8.28,32.4,19.656,44.784c3.456-11.736,5.544-26.64,13.896-32.76s27.36-6.264,15.264,18.864\n" +
"	c-12.096,25.128,3.528,38.736-0.144,58.536c-3.672,19.8-15.048,16.2-19.944,28.944c-4.896,12.744,2.88,41.76-6.336,54.792\n" +
"	c-9.216,13.032-10.872,33.048-4.896,49.032C172.339,205.374,162.763,168.726,162.763,168.726L162.763,168.726L162.763,168.726\n" +
"	L162.763,168.726z");
        SVGPath svgPath2 = new SVGPath();
        svgPath2.setContent("M48.355,185.646c-7.416,50.832-33.192,56.88-34.488,77.976\n" +
"	c-1.296,21.096,6.84,23.112,6.336,42.624c-0.504,19.512-17.856,27.432-19.944,38.016s8.928,13.968,15.336,13.968\n" +
"	c6.408,0,12.816-28.08,15.408-45.936s-8.496-28.368-8.496-40.608c0-12.24,16.056-34.632,13.104-14.976\n" +
"	C48.931,235.686,55.268,208.901,48.355,185.646L48.355,185.646L48.355,185.646L48.355,185.646z");
        root.getChildren().addAll(svgPath, svgPath1, svgPath2);
//
//        Path path = new Path();
//        path.getElements().add(new MoveTo(100f, 50f));
//        path.getElements().add(new CubicCurveTo(140f, 10f, 390f, 240f, 404, 10f));
//        path.getElements().add(new ClosePath());
//        root.getChildren().add(path);
        Scene scene = new Scene(root, 300, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
