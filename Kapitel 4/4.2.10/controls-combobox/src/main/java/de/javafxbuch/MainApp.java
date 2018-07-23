package de.javafxbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ComboBox<Person> cb = new ComboBox<>();
        Person neuer = new Person("Manuel", "Neuer", 28);
        cb.getItems().add(neuer);
        cb.getItems().add(new Person("Philipp", "Lahm", 30));
        cb.getItems().add(new Person("Mats", "Hummels", 25));
        cb.getItems().add(new Person("Jérôme", "Boateng", 25));
        cb.getItems().add(new Person("Benedikt", "Höwedes", 26));
        cb.setValue(neuer);
        //...
        cb.setConverter(new StringConverter<Person>() {
            @Override
            public String toString(Person p) {
                return p.getFirstName() + " " + p.getLastName() + " (" + p.getAge() + ")";
            }

            @Override
            public Person fromString(String string) {
                // muss für diesen Anwendungsfall nicht implementiert sein 
				throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        cb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue.getLastName());
        });

        StackPane pane = new StackPane(cb);
        Scene scene = new Scene(pane, 300, 250);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
