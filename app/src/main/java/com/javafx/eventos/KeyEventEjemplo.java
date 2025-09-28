package com.javafx.eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyEventEjemplo extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de KeyEvent en JavaFX");

        Label label=new Label("Texto: ");
        TextField cajaTexto=new TextField();
        VBox vbox=new VBox();
        vbox.getChildren().addAll(cajaTexto, label);//Añade nodos

        //Se podría indicar el tipo de evento o directamente una variable, llamada event, e o 
        //como queramos
        cajaTexto.setOnKeyPressed( event -> {
            System.out.println(event.getCode());
            if (event.getCode() == KeyCode.ENTER) {
               
                String txt=cajaTexto.getText();
                label.setText("Texto: " + txt);
                cajaTexto.clear();//Limpia caja

            }
            if (event.getCode() == KeyCode.ESCAPE) {
                label.setText("Texto: ");
                cajaTexto.clear();//Limpia caja

            }
        });

        Scene scene=new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
