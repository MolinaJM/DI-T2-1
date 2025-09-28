package com.javafx.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ButtonEjemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        
        Button buttonDesact=new Button();
        buttonDesact.setText("Púlsame!");
        buttonDesact.setDisable(true);
        

        Button button=new Button();
        button.setText("Púlsame!");

        //Se usa .setOnAction y la notación Lambda
        button.setOnAction((event) -> {
            System.out.println("Botón pulsado!");
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Cabecera");
            alert.setContentText("Botón pulsado. Click en Aceptar para cerrar");
            // Mostrar la alerta y esperar a que el usuario la cierre
            alert.showAndWait();
        });

        VBox vbox=new VBox(buttonDesact,button);
        Scene scene=new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
