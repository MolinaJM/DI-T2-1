package com.javafx.stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo_4_ApagadoAutomático extends Application {
    
    Integer tiempo=5000;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        Label label=new Label("Me apagaré automáticamente en "+tiempo+" ms");
        VBox vbox=new VBox(label);
        

        Scene scene=new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(100);
        primaryStage.show();


        new Thread( () -> {
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                primaryStage.close();
            });

        }).start();

    }

}
