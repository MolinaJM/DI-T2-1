package com.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo_0_Basico extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        VBox vbox=new VBox();
        Scene scene=new Scene(vbox);

        primaryStage.setTitle("Mi ventana");
        primaryStage.setX(250);//PosX 
        primaryStage.setY(250);//PosY
        primaryStage.setHeight(400);
        primaryStage.setWidth(250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
