package com.javafx.tabpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneEjemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TabPane tabPane=new TabPane();
        Tab tab1=new Tab("Aviones"); //Si metemos Nodos en el constructor, solamente podemos meter uno
        Tab tab2=new Tab("Coches"  , new Label("Aquí irían todos los coches"));
        Tab tab3=new Tab("Barcos" , new Label("Aquí irían todos los barcos"));

        tab1.setClosable(false);
        tab2.setClosable(false);
        tab3.setClosable(false);
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        
        //Añadir datos a un tab se hace de forma distinta a otro contenedor
        VBox vBox = new VBox(10);
        Button button=new Button("HOLA!");
        vBox.getChildren().add(new Label("Aquí irían todos los aviones"));
        vBox.getChildren().add(button);
        Pane pane = new Pane(vBox);
        tab1.setContent(pane);

        //Para saber donde hemos pinchado
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, viejo, nuevo) -> {
            if (nuevo != null) {
                System.out.println("Estamos en la pestaña " + nuevo.getText());
            }
        });

        //VBox vBox=new VBox(tabPane);
        Scene scene=new Scene(tabPane, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");

        primaryStage.show();
    }
}