/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author antonepple
 */
public class BindingFormSample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextField nameField = new TextField("");        
        SimpleStringProperty lastname = new SimpleStringProperty("Shaw");
        lastname.bind(nameField.textProperty());
        Label lastnameLabel = new Label();
        lastnameLabel.textProperty().bind(Bindings.concat("Nachname: ", lastname));
        VBox root = new VBox(nameField, lastnameLabel);
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
