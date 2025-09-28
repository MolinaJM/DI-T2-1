package com.javafx.filechooser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class EjemploFileChooser extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App - Selector de Ficheros");

        FileChooser fileChooser=new FileChooser();
        fileChooser.setInitialDirectory(new File("src"));//Dir. dentro de la estructura de proyecto
        //fileChooser.setInitialDirectory(new File("C:\\"));//Otro ejemplo WINDOWS
        //fileChooser.setInitialDirectory(new File("/"));//Otro ejemplo LINUX
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Clase JAVA", "*.java"),
                new FileChooser.ExtensionFilter("Ficheros de texto", "*.txt"),
                new FileChooser.ExtensionFilter("Imagen jpg", "*.jpg"),
                new FileChooser.ExtensionFilter("Ficheros HTML", "*.htm"),
                new FileChooser.ExtensionFilter("TODO", "*.*")
        );

        Button button=new Button("Selecciona fichero");
        button.setOnAction(e -> {
            File selectedFile=fileChooser.showOpenDialog(primaryStage);//pasándole el stage lo hacemos modal
            //también podemos abrir para guardar o para seleccionar múltiples ficheros.
            
            if (selectedFile != null) {
                System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
            } else {
                System.out.println("Ningún archivo seleccionado.");
            }

          
        });

        VBox vBox=new VBox(button);
        Scene scene=new Scene(vBox, 500, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
