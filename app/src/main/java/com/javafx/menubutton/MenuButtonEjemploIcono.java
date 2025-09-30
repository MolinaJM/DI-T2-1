package com.javafx.menubutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuButtonEjemploIcono extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //Se carga la imagen
        ImageView imageView=cargaImageViewAssets();

        MenuItem menuItem1=new MenuItem("Acción 1");
        MenuItem menuItem2=new MenuItem("Acción 2");
        MenuItem menuItem3=new MenuItem("Acción 3");
        MenuItem menuItem4=new MenuItem("Acción 4");
        //Nombre,Imagen y SUBITEMS
        MenuButton menuButton1=new MenuButton("Acciones", imageView, menuItem1, menuItem2, menuItem3, menuItem4);
        //Establecemos icono y fuente
        menuButton1.setGraphic(imageView);
        Font miFuente=Font.font("Courier New", FontWeight.BOLD, 12);
        menuButton1.setFont(miFuente);

        VBox vbox=new VBox(menuButton1);
        Scene scene=new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.show();
    }

    private ImageView cargaImageViewAssets() throws FileNotFoundException {
        FileInputStream input=new FileInputStream("assets/iconos/add.png");
        Image image=new Image(input);
        ImageView imageView=new ImageView(image);
        return imageView;
    }

}
