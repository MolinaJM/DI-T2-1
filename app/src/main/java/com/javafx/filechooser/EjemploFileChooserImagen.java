package com.javafx.filechooser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EjemploFileChooserImagen extends Application {

    ImageView foto;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App - Selector de Ficheros");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagen jpg", "*.jpg"),
                new FileChooser.ExtensionFilter("Imagen png", "*.png")
        );
        
        foto = new ImageView();

        Button button = new Button("Selecciona fichero");
        button.setTooltip(new Tooltip("Carga imagen en el ImageView"));
        button.setOnAction(e -> {
            File archivoSeleccionado = fileChooser.showOpenDialog(null);
            if (archivoSeleccionado != null) {
                System.out.println("NO URI:"+archivoSeleccionado.toString());
                //Convertimos
                String rutaArchivo = archivoSeleccionado.toURI().toString();
                System.out.println("URI:"+rutaArchivo);
                Image imagen = new Image(rutaArchivo);//Necesita tener URI para funcionar
                foto.setImage(imagen);
                foto.setFitWidth(200);
                foto.setFitHeight(200);
            }
        });

        VBox vBox = new VBox(button, foto);
        Scene scene = new Scene(vBox, 500, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
