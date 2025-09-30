package com.javafx.gridpane; //Modificar al package correcto

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemploGridPanePersonalizado extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        ObservableList<String> seriesLista = FXCollections.observableArrayList(
            "Breaking Bad",
            "The Sopranos",
            "The Wire",
            "Mad Men",
            "Lost",
            "Stranger Things",
            "Game of Thrones",
            "The Mandalorian",
            "Black Mirror",
            "Friends",
            "The Office (US)",
            "Parks and Recreation",
            "The Expanse",
            "True Detective",
            "Mindhunter",
            "Sherlock",
            "Dark",
            "BoJack Horseman",
            "Rick and Morty",
            "Avatar: The Last Airbender",
            "Making a Murderer",
            "Tiger King",
            "The Last Dance"
        );

        //Se rellena el array
        int fil,col;
        fil=0;col=3;
        for (int i = 0; i < seriesLista.size(); i++) { //Recorremos la lista entera
            if (i % col == 0){ //Cambio de fila cada col iteraciones
              fil++;  
            } 
            System.out.println("metiendo " + seriesLista.get(i) + " en pos " + col + " " + fil);
            StackPane p = creaPane(seriesLista.get(i), i);
            gridPane.add(p, i % col, fil);
        }
        //Espaciado horizontal y vertical y además un borde de 20px
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30));

        //Usamos un ScrollPane, se activa si crece su contenido!!
        //Un TV o un LV no necesitan esto porque ya lo implementan internamente
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);//Asignamos el contenido

        Scene scene = new Scene(scrollPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridView Interactivo");
        primaryStage.show();
    }

    //Se devuelve un StackPane porque lo centra todo automáticamente!!
    //Un Pane no nos valdría
    private StackPane creaPane(String serie, Integer i) {
        StackPane p = new StackPane();
        p.setPrefSize(100, 100);//Forzamos un tamaño fijo, si no, dependerá del contenido
        p.setStyle("-fx-background-color: lightblue");
        Button b = new Button("DATOS");
        Label l = new Label(serie);
        VBox vbox = new VBox(10, l, b);//10px entre elementos
        vbox.setAlignment(Pos.CENTER);//Alinea al centro
        p.getChildren().add(vbox);
        p.setOpacity(0.8);
        //Agregar un evento de clic a la imagen
        b.setOnMouseClicked(event -> {
            System.out.println("Click en " + serie + " en indice " + i);
        });

        //Agregar un evento de mouse hover y exit (ratón sobre o fuera de la Foto)
        p.setOnMouseEntered(event -> {
            p.setOpacity(1.0);
            p.setStyle("-fx-background-color: lightgreen");
        });

        p.setOnMouseExited(event -> {
            p.setOpacity(0.8);
            p.setStyle("-fx-background-color: lightblue");
        });

        return p;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
