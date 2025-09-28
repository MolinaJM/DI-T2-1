package com.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ejemplo_5_MultiplesStages extends Application  {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox=new VBox();
        Scene scene=new Scene(vbox);

        primaryStage.setTitle("PRIMERA");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage=new Stage();
        stage.setTitle("SEGUNDA");
        stage.setX(300);
        stage.setY(300);

        stage.setWidth(300);
        stage.setHeight(300);
        
        //Podemos poner dependiente el segundo stage (y que al cerrar el primero también 
        // cierre el segundo
        //stage.initOwner(primaryStage);
        
        //O por el contrario podemos poner modal el segundo stage
        stage.initModality(Modality.APPLICATION_MODAL); // Configura el diálogo como modal
        
        stage.show();
    }



}
