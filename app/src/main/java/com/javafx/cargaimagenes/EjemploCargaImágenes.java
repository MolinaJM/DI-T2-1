package com.javafx.cargaimagenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.layout.HBox;

public class EjemploCargaImágenes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //3 formas de cargar imágenes
        // 1: desde ASSETS
        ImageView imageView1=cargaImageViewAssets();
        
        // 2: desde URL
        ImageView imageView2 = new ImageView();
        Image imagen = new Image("https://images.virgula.me/2017/04/robocop1.jpg", true);//Booleano para preservar el ratio
        imageView2.setImage(imagen);
        imageView2.setFitHeight(80);
        imageView2.setFitWidth(80);
        
        //3: desde RESOURCES
        Image icono=new Image(getClass().getClassLoader().getResourceAsStream("pcicon.png"));
        ImageView imageView3 = new ImageView(icono);

        HBox hbox=new HBox(imageView1,imageView2,imageView3);
        Scene scene=new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(200);
        primaryStage.setHeight(130);
        primaryStage.show();
    }

    private ImageView cargaImageViewAssets() throws FileNotFoundException {
        //ASSETS
        FileInputStream input=new FileInputStream("assets/iconos/add.png");
        System.out.println(input);
        Image image=new Image(input);
        ImageView imageView=new ImageView(image);
        return imageView;
    }

}

