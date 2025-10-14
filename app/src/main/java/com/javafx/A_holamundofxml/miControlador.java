package com.javafx.A_holamundofxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Molina
 */
public class miControlador implements Initializable {

    @FXML
    private Label miEtiqueta;

    @FXML
    private void botonPulsado(ActionEvent event) {
        miEtiqueta.setText("Hola Mundo");
        System.out.println("Hola Mundo!!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        miEtiqueta.setText("");
    }
}
