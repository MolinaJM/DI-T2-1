package com.javafx.eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowEventoCierre extends Application {

    @Override
    public void start(Stage primaryStage) {
       
        primaryStage.setTitle("Manejo de Evento de Cierre");

        //Se configura para que haga lo que queramos al cerrar
        primaryStage.setOnCloseRequest(event -> {
            event.consume(); // Evita el cierre (consume el evento)
            //Si no se pone, al darle a Cancelar cierra porque ya se había dado la orden

            // Mostrar un Alert
            Alert alert=new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("¿De VERDAD estás seguro de que quieres salir?");
            alert.setContentText("OK si quieres salir o Cancelar para volver");

            //Se configura Alert con opciones
            //El orElse indica que si cerramos el diálogo, tomará la opción CANCEL
            ButtonType result=alert.showAndWait().orElse(ButtonType.CANCEL);
            System.out.println(result.toString());
            if (result == ButtonType.OK) {
                primaryStage.close(); // Cierra la ventana si el usuario confirma
            }
        });

        // Configurar la escena y mostrar la ventana
        Scene scene=new Scene(new VBox(), 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

