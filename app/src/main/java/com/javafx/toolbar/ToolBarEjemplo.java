package com.javafx.toolbar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToolBarEjemplo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        ToolBar toolBar=new ToolBar();

        Button button0=new Button("CLIENTES");
        toolBar.getItems().add(button0);
        //Podríamos añadir imágenes (ver proyecto com.javafx.cargaimagenes)
        
        toolBar.getItems().add(new Separator());
        Button button1=new Button("PRODUCTOS");
        toolBar.getItems().add(button1);
        toolBar.getItems().add(new Separator());
        Button button2=new Button("VENTAS");
        toolBar.getItems().add(button2);

        VBox vBox=new VBox(toolBar);

        Scene scene=new Scene(vBox, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
