package com.javafx;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Esta APP carga mediante Reflexión cualquier clase JAVAFX desde un selector de
 * Ficheros
 *
 * @author JMMolina
 */
public class LanzadorEjemplosFX extends Application {

    File file;
    FileChooser fileChooser;
    File ultimoDirectorio = null; //Variable para almacenar el último directorio seleccionado

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir clases ejemplo JAVAFX");

        fileChooser.setInitialDirectory(new File("."));

        FileChooser.ExtensionFilter filtro = new FileChooser.ExtensionFilter("Ejemplos Clases FX", "*.java");
        fileChooser.getExtensionFilters().add(filtro);

        Button button = new Button("Abrir FileChooser");
        button.setOnAction(e -> {
            file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                ultimoDirectorio = file.getParentFile();
                fileChooser.setInitialDirectory(ultimoDirectorio);
                System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
                String className = file.getName().replace(".java", "");
                className = "com.javafx." + file.getParentFile().getName() + "." + className;
                System.out.println("Clase:" + className);

                Class<?> clazz = null;
                try {
                    clazz = Class.forName(className);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LanzadorEjemplosFX.class.getName()).log(Level.SEVERE, null, ex);
                }
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                try {
                    try {
                        Object instancia = clazz.getDeclaredConstructor().newInstance();
                        System.out.println(instancia);

                        // Comprobamos si la instancia es una subclase de Application
                        if (instancia instanceof Application) {
                            Application application = (Application) instancia;
                            System.out.println("Abriendo APP..");
                            try {
                                application.start(stage);
                            } catch (Exception ex) {
                                Logger.getLogger(LanzadorEjemplosFX.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    } catch (NoSuchMethodException | SecurityException ex) {
                        Logger.getLogger(LanzadorEjemplosFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(LanzadorEjemplosFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Cancelar");
            }
        });

        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/3/30/JavaFX_text_logo.png";
        Image image = new Image(imageUrl);
        // Crear un ImageView con la imagen
        ImageView imageView = new ImageView(image);

        //Se crea contenedor y se añaden los nodos
        StackPane root = new StackPane(imageView, button); //Se añaden los nodos en orden
        // root.getChildren().add(imageView);
        Scene scene = new Scene(root, 430, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lanzador de Ejemplos JAVAFX - JMMolina 2DAM");
        primaryStage.show();
    }
}
