package com.javafx.alertas;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AlertasEjemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Ejemplo de Alertas en JavaFX");

        // Alerta de información
        Alert alertInfo=new Alert(AlertType.INFORMATION);
        alertInfo.setTitle("Información");
        alertInfo.setHeaderText("Esto es la cabecera");
        alertInfo.setContentText("Este es el contenido");
        
        
        // Alerta de advertencia
        Alert alertWarning=new Alert(AlertType.WARNING);
        alertWarning.setTitle("Advertencia");
        alertWarning.setHeaderText("Quien avisa no es traidor...");
        alertWarning.setContentText("Este es el contenido");

        // Alerta de error
        Alert alertError=new Alert(AlertType.ERROR);
        alertError.setTitle("Error");
        alertError.setHeaderText("Esto es una alerta de error");
        alertError.setContentText("Todo se ha ido a la ...");

        // Alerta de confirmación
        Alert alertConfirmation=new Alert(AlertType.CONFIRMATION);
        alertConfirmation.setTitle("Confirmación");
        alertConfirmation.setHeaderText("Esto es una alerta de confirmación");
        alertConfirmation.setContentText("Estás seguro de que quieres seguir?");

        // Mostrar las AlertasEjemplo. Son MODALES, se presenta una a una.
        // No tendría sentido mostrarlas solo cn .show()
        alertInfo.showAndWait();
        alertWarning.showAndWait();
        alertError.showAndWait();
        ButtonType resultado=alertConfirmation.showAndWait().orElse(ButtonType.CANCEL);

        // Procesar la respuesta del usuario
        if (resultado == javafx.scene.control.ButtonType.OK) {
            System.out.println("Has pinchado en Aceptar");
        } else if (resultado == javafx.scene.control.ButtonType.CANCEL) {
            System.out.println("Has pinchado en Cancelar");
        }

    }
}
