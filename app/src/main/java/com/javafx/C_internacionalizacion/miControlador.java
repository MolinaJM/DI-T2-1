package com.javafx.C_internacionalizacion;

import java.net.URL;
import java.util.ResourceBundle;
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
    private void botonPulsado() {
        miEtiqueta.setText("Hola Mundo"); //No se traduce porque no es diseño, sino funcionamiento
        System.out.println("Hola Mundo!!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        miEtiqueta.setText("");
    }
}
