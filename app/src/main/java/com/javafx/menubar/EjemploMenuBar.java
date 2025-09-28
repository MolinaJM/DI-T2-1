package com.javafx.menubar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EjemploMenuBar extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de MenuBar");
        
        // Crear un menú "Archivo" con elementos de menú
        Menu fileMenu=new Menu("Archivo");
        MenuItem nuevo=new MenuItem("Nuevo");
        MenuItem abrir=new MenuItem("Abrir");
        MenuItem salir=new MenuItem("Salir");
        fileMenu.getItems().addAll(nuevo, abrir, new SeparatorMenuItem(), salir);

        //Acciones según elemento
        nuevo.setOnAction(e -> System.out.println("Nuevo archivo"));
        abrir.setOnAction(e -> System.out.println("Abrir archivo"));
        salir.setOnAction(e -> primaryStage.close());


        
        //Menú opciones
        Menu opciones=new Menu("Opciones");
        //Checkbox
        CheckMenuItem checkItem1=new CheckMenuItem("Opción 1");
        CheckMenuItem checkItem2=new CheckMenuItem("Opción 2");
        //Radios
        ToggleGroup radioGroup=new ToggleGroup();
        RadioMenuItem radioItem1=new RadioMenuItem("Radio 1");
        radioItem1.setToggleGroup(radioGroup);
        RadioMenuItem radioItem2=new RadioMenuItem("Radio 2");
        radioItem2.setToggleGroup(radioGroup);

        // Agregar elementos al menú "Opciones"
        opciones.getItems().addAll(checkItem1, checkItem2, new SeparatorMenuItem(), radioItem1, radioItem2);

         
        //menú "Ayuda" 
        Menu ayuda=new Menu("Ayuda");
        MenuItem manual=new MenuItem("Manual de Usuario");
        ayuda.getItems().add(manual);

        //Crear barra y configura 
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu, opciones,ayuda);

        //Layout: necesitamos un layout que permita colocar elementos según posición
        BorderPane root=new BorderPane();
        root.setTop(menuBar);
        Scene scene=new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
