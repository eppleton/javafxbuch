/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 *
 * @author antonepple
 */
public class FormController implements Initializable {

    @FXML
    Slider slider1;
    @FXML
    Slider slider2;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label add;
    @FXML
    Label subtract;
    @FXML
    Label multiply;
    @FXML
    Label divide;
    @FXML
    Label negate;
    @FXML
    Label max;
    @FXML
    Label min;
    @FXML
    Label greaterThan;
    @FXML
    Label greaterThanOrEqualTo;
    @FXML
    Label isEqualTo;
    @FXML
    Label isNotEqualTo;
    @FXML
    Label lessThan;
    @FXML
    Label lessThanOrEqualTo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label1.textProperty().bind(slider1.valueProperty().asString());
        label2.textProperty().bind(slider2.valueProperty().asString());
        add.textProperty().bind(slider1.valueProperty().add(slider2.valueProperty()).asString());
        subtract.textProperty().bind(slider1.valueProperty().subtract(slider2.valueProperty()).asString());
        multiply.textProperty().bind(slider1.valueProperty().multiply(slider2.valueProperty()).asString());
        divide.textProperty().bind(slider1.valueProperty().divide(slider2.valueProperty()).asString());
        negate.textProperty().bind(slider1.valueProperty().negate().asString());
        max.textProperty().bind(Bindings.max(slider1.valueProperty(),slider2.valueProperty()).asString());
        min.textProperty().bind(Bindings.min(slider1.valueProperty(),slider2.valueProperty()).asString());
        greaterThan.textProperty().bind(Bindings.greaterThan(slider1.valueProperty(),slider2.valueProperty()).asString());
        greaterThanOrEqualTo.textProperty().bind(slider1.valueProperty().greaterThanOrEqualTo(slider2.valueProperty()).asString());
        isEqualTo.textProperty().bind(slider1.valueProperty().isEqualTo(slider2.valueProperty()).asString());
        isNotEqualTo.textProperty().bind(slider1.valueProperty().isNotEqualTo(slider2.valueProperty()).asString());
        lessThan.textProperty().bind(slider1.valueProperty().lessThan(slider2.valueProperty()).asString());
        lessThanOrEqualTo.textProperty().bind(slider1.valueProperty().lessThanOrEqualTo(slider2.valueProperty()).asString());
        
    }

}
