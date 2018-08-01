package de.javafxbuch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) {
        TableView<Player> tableView = new TableView<>();
        ObservableList<Player> players = FXCollections
                .observableArrayList(
                        new Player("Manuel", "Neuer", 0),
                        new Player("Philipp", "Lahm", 0),
                        new Player("Mats", "Hummels", 2),
                        new Player("Jérôme", "Boateng", 0),
                        new Player("Benedikt", "Höwedes", 0)
                );
        tableView.setItems(players);
        TableColumn<Player, String> firstName = new TableColumn<>("Vorname");
        TableColumn<Player, String> lastName = new TableColumn<>("Nachname");
        TableColumn<Player, Integer> goals = new TableColumn<>("Tore");
        tableView.getColumns().addAll(firstName, lastName, goals);
        firstName.setCellValueFactory(
                new PropertyValueFactory<Player, String>("firstName")
        );
        lastName.setCellValueFactory(
                new PropertyValueFactory<Player, String>("lastName"));
        goals.setCellValueFactory(
                new PropertyValueFactory<Player, Integer>("goals")
        );
        goals.setCellFactory(new Callback<TableColumn< Player, Integer>, TableCell<Player, Integer>>() {
            @Override
            public TableCell< Player, Integer> call(TableColumn< Player, Integer> param) {
                return new GoalsCell();
            }
        });

        tableView.setEditable(true);
        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        firstName.setOnEditCommit(new EventHandler<CellEditEvent<Player, String>>() {
            @Override
            public void handle(CellEditEvent<Player, String> t) {
                ((Player) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        });
        StackPane root = new StackPane(tableView);
        Scene scene = new Scene(root, 300, 250);
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
