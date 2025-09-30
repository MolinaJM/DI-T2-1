package com.javafx.observablelist;

import java.util.Collections;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.collections.FXCollections;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

/*
Lista Observable permite lanzar eventos ante cualquier cambio
 */
public class EjemploObservableList extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        // Configurar tamaño preferido del TextArea
        textArea.setPrefSize(200, 400);
        // Crear un contenedor y agregar el TextArea
        VBox vbox = new VBox(textArea);

        //Puede ser una lista de CUALQUIER clase
        ObservableList<Integer> listaNum = FXCollections.observableArrayList(1, 2, 3);
        //Registrar un listener para la lista con los métodos: next, wasPermutated, wasReplaced, wasRemoved y wasAdded
        listaNum.addListener((ListChangeListener<Integer>) change -> {
            while (change.next()) {
                if (change.wasPermutated()) {
                    // permutacion
                    textArea.appendText("Elementos INTERCAMBIADOS: " + change.getFrom() + " por " + change.getTo() + "\n");
                } else if (change.wasReplaced()) {
                    // reemplazo
                    textArea.appendText("Elemento REEMPLAZADO: " + change.getRemoved() + " por " + change.getAddedSubList() + "\n");
                } else if (change.wasRemoved()) {
                        // elemento borrado
                        textArea.appendText("Elementos ELIMINADOS: " + change.getRemoved() + "\n");
                } else if (change.wasAdded()) {
                        // elemento añadido
                        textArea.appendText("Elementos AGREGADOS: " + change.getAddedSubList() + "\n");
                    }
                }
        });

        textArea.appendText("Contenido lista:" + listaNum.toString() + "\n\n");
        listaNum.add(10);//AÑADIDO
        listaNum.addAll(100, 200, 300);
        textArea.appendText("Contenido lista:" + listaNum.toString() + "\n\n");
        listaNum.set(2, 500);//REEMPLAZO
        textArea.appendText("Contenido lista:" + listaNum.toString() + "\n\n");
        listaNum.remove(0);//BORRADO
        textArea.appendText("Contenido lista:" + listaNum.toString() + "\n\n");
        Collections.sort(listaNum); //PERMUTACIÓN
        textArea.appendText("Contenido lista:" + listaNum.toString() + "\n\n");
        listaNum.set(0, 1000);//REEMPLAZO
        textArea.appendText("Contenido lista:" + listaNum.toString() + "\n\n");

        ObservableList<Integer> otraLista = FXCollections.observableArrayList(1000, 2000, 3000);
        //También se puede añadir otra lista del  mismo tipo
        listaNum.addAll(otraLista);

        primaryStage.setTitle("Lista Observable");
        primaryStage.setHeight(400);
        primaryStage.setWidth(300);
        // Crear una escena y agregar el contenedor
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
