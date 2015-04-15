package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Datei");
        MenuItem openProjectMenuItem = new MenuItem(
                "Projekt öffnen...");
        fileMenu.getItems().add(openProjectMenuItem);
        Menu helpMenu = new Menu("Hilfe");
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        root.setTop(menuBar);
        ImageView imageView = new ImageView(new Image(getClass().getResource("javaduke_html5.png").toExternalForm()));
        root.setCenter(imageView);
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem halloMenuItem = new MenuItem("Sag 'Hallo'");
        halloMenuItem.setOnAction(
                e -> System.out.println("Duke: 'Hallo!'"));
        contextMenu.getItems().add(halloMenuItem);

        openProjectMenuItem.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.showOpenDialog(primaryStage);
        });
        openProjectMenuItem.setAccelerator(KeyCombination.valueOf("Ctrl+O"));
        openProjectMenuItem.setGraphic(new ImageView(
                new Image("de/javafxbuch/project_open.png")));
        fileMenu.getItems().add(new SeparatorMenuItem());
        CheckMenuItem showDukeMenuItem = new CheckMenuItem("Duke anzeigen");
        showDukeMenuItem.setSelected(true);
        fileMenu.getItems().add(showDukeMenuItem);
        imageView.visibleProperty().bind(
                showDukeMenuItem.selectedProperty());
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem smallDukeMenuItem = new RadioMenuItem(
                "Kleiner Duke");
        smallDukeMenuItem.setToggleGroup(toggleGroup);
        fileMenu.getItems().add(smallDukeMenuItem);
        RadioMenuItem largeDukeMenuItem = new RadioMenuItem(
                "Großer Duke");
        largeDukeMenuItem.setToggleGroup(toggleGroup);
        fileMenu.getItems().add(largeDukeMenuItem);
        DoubleBinding scaleBinding = Bindings.createDoubleBinding(
                () -> smallDukeMenuItem.isSelected() ? 0.5 : 1.0, smallDukeMenuItem.selectedProperty());
        imageView.scaleXProperty().bind(scaleBinding);
        imageView.scaleYProperty().bind(scaleBinding);

        imageView.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(imageView, e.getScreenX(), e.getScreenY());
            }
        });
        Slider fadeSlider = new Slider(0, 1, 1);
        imageView.opacityProperty().bind(fadeSlider.valueProperty());
        CustomMenuItem customMenuItem = new CustomMenuItem(fadeSlider,
                false);
        fileMenu.getItems().add(customMenuItem);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("MenuBar Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
