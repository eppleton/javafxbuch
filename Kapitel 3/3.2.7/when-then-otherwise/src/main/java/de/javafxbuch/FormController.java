/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author antonepple
 */
public class FormController implements Initializable {

    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    CheckBox javaFx;
    @FXML
    CheckBox performanceTuning;
    @FXML
    CheckBox javaSpecialistMaster;
    @FXML
    Button saveButton;
    @FXML 
    Label suggestion;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BooleanBinding nameEntered = firstName.textProperty().isNotEmpty()
                .and(firstName.textProperty().length().greaterThan(1))
                .and(lastName.textProperty().isNotEmpty())
                .and(lastName.textProperty().length().greaterThan(1));

        BooleanBinding courseSelected = performanceTuning.selectedProperty()
                .or(javaFx.selectedProperty()
                        .or(javaSpecialistMaster.selectedProperty()));

        saveButton.disableProperty().bind(courseSelected.and(nameEntered).not());
        StringBinding suggestJavaFXIfNotChosen = new When(javaFx.selectedProperty())
                .then(javaFx.textProperty())
                .otherwise("Warum nicht JavaFX?");
        suggestion.textProperty().bind(suggestJavaFXIfNotChosen);
        
    }

}
