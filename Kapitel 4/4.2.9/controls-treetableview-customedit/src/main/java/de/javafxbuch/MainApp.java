package de.javafxbuch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TreeView treeView = new TreeView();
        TreeItem<Color> root = new TreeItem<>(Color.RED);
        treeView.setRoot(root);
        treeView.setEditable(true);
        treeView.setCellFactory(new Callback<TreeView<Color>, TreeCell<Color>>() {
            @Override
            public TreeCell<Color> call(TreeView<Color> param) {
                TreeCell<Color> treeCell = new TreeCell<Color>() {
                    ColorPicker cp = new ColorPicker();

                    @Override
                    public void startEdit() {
                        super.startEdit();
                        setText("");
                        cp.setValue(getItem());
                        cp.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                commitEdit(cp.getValue());
                            }
                        });
                        setGraphic(cp);
                    }

                    @Override
                    protected void updateItem(Color item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty && item != null) {
                            setText(item.toString());
                            Rectangle rectangle = new Rectangle(16, 16);
                            rectangle.setFill(item);
                            setGraphic(rectangle);
                        } else {
                            setText("");
                            setGraphic(null);
                        }
                    }
                };
                return treeCell;
            }
        });
        root.getChildren()
                .add(new TreeItem<Color>(Color.BLUE));
        StackPane pane = new StackPane(treeView);
        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setTitle(
                "TableView Demo");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
