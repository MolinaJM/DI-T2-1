package com.javafx.scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EjemploCambioScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button b = new Button("Cambia a Scene 2");
        VBox vbox1 = new VBox(new Label("HOLA DESDE SCENE 1"), b);
        Scene scene1 = new Scene(vbox1);

        Button b2 = new Button("Cambia a Scene 1");
        VBox vbox2 = new VBox(new Label("HOLA DESDE SCENE 2"),b2);
        Scene scene2 = new Scene(vbox2);

        b.setOnAction(e -> {
            primaryStage.setScene(scene2);
            primaryStage.show();
        });
        
        b2.setOnAction(e -> {
            primaryStage.setScene(scene1);
            primaryStage.show();
        });

        primaryStage.setTitle("Ejemplo Cambio de Scene");
        primaryStage.setHeight(200);
        primaryStage.setWidth(380);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

}
