package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(125);
        circle.setRadius(75);
        circle.setFill(Color.BLUE);

        Ellipse circle2 = new Ellipse();
        circle2.setCenterX(200);
        circle2.setCenterY(125);
        circle2.setFill(Color.RED);
        circle2.setRadiusX(75);
        circle2.setRadiusY(75);

        Line line = new Line(100, 85, 100, 40);
        line.setStroke(Color.WHITE);
        line.setStrokeWidth(3);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        line.getStrokeDashArray().addAll(5d);
        Line line2 = new Line(200, 85, 200, 40);
        line2.setStrokeWidth(3);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        line2.getStrokeDashArray().addAll(5d);
        line2.setStroke(Color.WHITE);
        Line line3 = new Line(150, 165, 150, 210);
        line3.setStroke(Color.WHITE);
        line3.setStrokeWidth(3);
        line3.setStrokeLineCap(StrokeLineCap.ROUND);
        line3.getStrokeDashArray().addAll(5d);

        Polyline polyline = new Polyline(95, 85, 105, 85, 100, 90, 95, 85);
        polyline.setStroke(Color.WHITE);
        polyline.setStrokeWidth(3);
        polyline.setStrokeLineCap(StrokeLineCap.ROUND);
        polyline.setStrokeLineJoin(StrokeLineJoin.ROUND);

        Polygon polygon = new Polygon(195, 85, 205, 85, 200, 90);
        polygon.setStroke(Color.WHITE);
        polygon.setStrokeWidth(3);
        polygon.setStrokeLineJoin(StrokeLineJoin.ROUND);
        Polygon polygon2 = new Polygon(145, 165, 155, 165, 150, 160);
        polygon2.setStroke(Color.WHITE);
        polygon2.setStrokeWidth(3);
        polygon2.setStrokeLineJoin(StrokeLineJoin.ROUND);

        Shape union = Shape.intersect(circle, circle2);
        union.setFill(Color.PURPLE);
        Rectangle rectangle = new Rectangle(20, 20, 260, 210);
        rectangle.setFill(Color.LIGHTGREY);
        Group root = new Group();

        Arc arc = new Arc(100, 125, 50, 50, 180, 180);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(3);

        Arc arc1 = new Arc(100, 110, 30, 30, 240, 60);
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc(80, 80, 30, 30, 240, 60);
        arc2.setType(ArcType.CHORD);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.BLACK);
        arc2.setStrokeWidth(3);
        Arc arc3 = new Arc(120, 80, 30, 30, 240, 60);
////...
        arc3.setType(ArcType.CHORD);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.BLACK);
        arc3.setStrokeWidth(3);

        QuadCurve quad = new QuadCurve();
        quad.setStartX(185);
        quad.setStartY(105);
        quad.setEndX(195);
        quad.setEndY(105);
        quad.setControlX(190);
        quad.setControlY(140);
        QuadCurve quad2 = new QuadCurve(215, 105, 220, 140, 225, 105);

        CubicCurve cubicCurve = new CubicCurve(185, 155, 195, 140, 205, 170, 215, 155);

        Text text = new Text(55, 35, "Music I like");
        text.setFill(Color.WHITE);
        Text text2 = new Text(155, 35, "Music you like");
        text2.setFill(Color.WHITE);
        Text text3 = new Text(105, 225, "Music I used to like");
        text3.setFill(Color.WHITE);

        text.setWrappingWidth(50);
        text.setTextAlignment(TextAlignment.CENTER);
        text2.setFont(new Font(8));
        text3.setStrikethrough(true);

        root.getChildren().add(rectangle);
        root.getChildren().add(circle);
        root.getChildren().add(circle2);
        root.getChildren().add(union);
        root.getChildren().addAll(line, line2, line3);
        root.getChildren().addAll(polyline, polygon, polygon2);
        root.getChildren().addAll(arc, arc1, arc2, arc3);
        root.getChildren().addAll(quad, quad2);
        root.getChildren().add(cubicCurve);
        root.getChildren().addAll(text, text2, text3);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
