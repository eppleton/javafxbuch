package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<Player> treeTableView = new TreeTableView<>();
        TreeItem<Player> root = new TreeItem<>(new Player("Joachim", "Löw", 0));
        root.getChildren().add(new TreeItem<Player>(
                new Player("Manuel", "Neuer", 0)));
        root.getChildren().add(new TreeItem<Player>(new Player("Philipp", "Lahm", 0)));
        treeTableView.setRoot(root);
        TreeTableColumn<Player, String> firstNameColumn = new TreeTableColumn<Player, String>("Vorname");
        firstNameColumn.setCellValueFactory(
                new TreeItemPropertyValueFactory<Player, String>("firstName"));
        TreeTableColumn<Player, String> lastNameColumn = new TreeTableColumn<Player, String>("Nachname");
        lastNameColumn.setCellValueFactory(
                new TreeItemPropertyValueFactory<Player, String>("lastName"));
        TreeTableColumn<Player, Integer> goalsColumn = new TreeTableColumn<Player, Integer>("Tore");
        goalsColumn.setCellValueFactory(
                new TreeItemPropertyValueFactory<Player, Integer>("goals"));
        treeTableView.getColumns().add(firstNameColumn);
        treeTableView.getColumns().add(lastNameColumn);
        treeTableView.getColumns().add(goalsColumn);
        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
        StackPane pane = new StackPane(treeTableView);
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("TableView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class GoalsCell extends TableCell<Player, Integer> {

        private final HBox goalsBox;
        private final Image goalImage;

        public GoalsCell() {
            goalsBox = new HBox();
            goalImage = new Image(GoalsCell.class.getResource("world.png").toString());
        }

        @Override
        protected void updateItem(Integer item, boolean empty) {
            setText("");
            goalsBox.getChildren().clear();
            if (item != null) {
                for (int i = 0; i < item; i++) {
                    goalsBox.getChildren().add(new ImageView(goalImage));
                }
            }
            setGraphic(goalsBox);
        }
    }
}
