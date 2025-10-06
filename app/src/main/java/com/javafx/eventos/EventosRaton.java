package com.javafx.eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EventosRaton extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 300);

        scene.setOnMouseClicked(e -> eventosRaton(e));
        primaryStage.setTitle("Mouse Click Detector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void eventosRaton(MouseEvent event) {
        MouseButton button = event.getButton();

        String buttonName = switch (button) {
            case PRIMARY -> "Izquierdo";
            case SECONDARY -> "Derecho";
            case MIDDLE -> "Central";
            default -> "Desconocido";
        };

        if (event.getClickCount() == 2) {
            System.out.println("Doble Click con botón " + buttonName);
        } else if (event.getClickCount() == 1) {
            System.out.println("Has clicado con botón " + buttonName);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}