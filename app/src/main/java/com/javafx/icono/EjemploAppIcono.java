package com.javafx.icono;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EjemploAppIcono extends Application {

    
    
    public static void main(String[] args) {
        System.out.println(args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label label=new Label("Aplicación mínima con icono");

        Scene scene=new Scene(new Pane(label), 300, 250);
        primaryStage.setScene(scene);
        
        //Añadir icono (ver proyecto com.javafx.cargaimagenes)
        Image icon=new Image(getClass().getClassLoader().getResourceAsStream("pcicon.png"));
        
        primaryStage.setTitle("APP Mínima no resizable");
        primaryStage.getIcons().add(icon);//Asignación de icono al stage
        primaryStage.setHeight(300);
        primaryStage.setWidth(400);
        primaryStage.setResizable(false);
        
        primaryStage.show();
    }
}