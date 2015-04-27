/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.javafxbuch;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author antonepple
 */
public class FXMLDocumentController {
    @FXML
    private void handleButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("de/javafxbuch/bundle");
        System.out.println(bundle.getString("hello_world_message"));
    }
}
