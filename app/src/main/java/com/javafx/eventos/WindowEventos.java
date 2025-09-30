 package com.javafx.eventos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class WindowEventos extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de Evento de Ventana");

        Button closeButton=new Button("Cerrar Ventana");
        closeButton.setOnAction(e -> primaryStage.close()); //No hay bloque porque solo es una orden

        StackPane layout=new StackPane();
        layout.getChildren().add(closeButton);

        Scene scene=new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        // Otra variante: Manejar el evento de cierre de ventana sin usar expresión lambda
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println(event);
                System.out.println("La ventana se está cerrando.");
            }
        });
        
        //Equivalencia con expresión lambda
        /*primaryStage.setOnCloseRequest((WindowEvent event) -> {
            System.out.println("La ventana se está cerrando.");
        });*/

        primaryStage.show();
    }
}
