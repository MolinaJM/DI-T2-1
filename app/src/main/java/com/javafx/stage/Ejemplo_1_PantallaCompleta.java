package com.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Ejemplo_1_PantallaCompleta  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox=new VBox();
        Scene scene=new Scene(vbox);

        primaryStage.setTitle("No me veo!!");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);//Título que NO se verá

        primaryStage.show();
    }


}
