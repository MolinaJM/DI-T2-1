package com.javafx.gridpane; //Modificar al package correcto

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EjemploGridPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane=new GridPane();

        //Se rellena el array
        for (int fila=0; fila < 3; fila++) {
            for (int columna=0; columna < 3; columna++) {
                //Estamos creando imagen con funcionamiento personalizado.
                //Hay que crear objetos nuevos cada vez porque son independientes
                ImageView imageView=creaFoto("https://images.virgula.me/2017/04/robocop1.jpg");
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                //GridPane es un contenedor de Nodos personalizados, en este caso, un imageView custom
                gridPane.add(imageView, columna, fila);

            }
        }
        //Espaciado horizontal y vertical y además un borde de 20px
        gridPane.setHgap(10); 
        gridPane.setVgap(10); 
        gridPane.setPadding(new Insets(30)); 

        Scene scene=new Scene(gridPane, 380, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridView Interactivo");
        primaryStage.show();
    }

    private ImageView creaFoto(String imageURL) {
        Image image=new Image(imageURL);
        ImageView imageView=new ImageView(image);

        //Agregar un evento de clic a la imagen
        //Pero NO puedo saber fila/columna
        imageView.setOnMouseClicked(event -> {
            System.out.println("Click en " + imageURL+ " No sabemos Fila/Columna porque no se registra!!!");
        });

        //Agregar un evento de mouse hover y exit (ratón sobre o fuera de la Foto)
        imageView.setOnMouseEntered(event -> {
            imageView.setOpacity(0.5); 
        });

        imageView.setOnMouseExited(event -> {
            imageView.setOpacity(1.0); 
        });

        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
