package com.javafx.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonIntroBotónEscapeCancel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField campoTexto = new TextField();

        Button button = new Button("Haz click!");

        button.setOnAction((event) -> {
            System.out.println("Botón Pulsado!");
        });
        button.setCancelButton(false);
        button.setDefaultButton(false);

        Button buttonDefault = new Button("Default (OK)");

        buttonDefault.setOnAction((event) -> {
            System.out.println("Botón por Defecto pulsado (INTRO)!");
        });
        buttonDefault.setCancelButton(false);
        buttonDefault.setDefaultButton(true);//ACTIVADO! Se dispara con INTRO

        Button buttonCancel = new Button("Cancel");

        buttonCancel.setOnAction((event) -> {
            System.out.println("Botón Cancel Pulsado (ESCAPE) !");
        });
        buttonCancel.setCancelButton(true);//Activado! Se dispara con ESCAPE
        buttonCancel.setDefaultButton(false);

        //Botón con Imagen
        Image icono=new Image(getClass().getClassLoader().getResourceAsStream("pcicon.png"));
        ImageView imageView = new ImageView(icono);
        //Forma 1 de establecer imagen en botón
        Button bImagen = new Button("Botón con Imagen",imageView);
        //Forma 2 de establecer imagen en botón (si no se le pasa en el constructor)
        //buttonCancel.setGraphic(imageView);

        HBox vbox = new HBox(campoTexto, button, buttonDefault, buttonCancel,bImagen);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(512);
        primaryStage.setHeight(512);
        primaryStage.show();
    }

}
