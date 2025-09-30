package com.javafx.tableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EjemploTableView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException, FileNotFoundException {
        //TableView son contenedores de un MODELO(Clase) gobernados por una OL
        //Por tanto, lo primero es crear el modelo (Robot)

        //La fuente de datos puede ser directa, también se podría leer de una base de datos, fichero, etc... 
        //y rellenar con lo que se fuera leyendo
        //4 formas de añadir datos al OL. 
        //1 Directamente en el constructor
        ObservableList<Robot> lista = FXCollections.observableArrayList(
                new Robot("Robocop", "Robocop")
        );
        TableView tableView = new TableView(lista);
        //2 Añadiendo de uno en uno
        tableView.getItems().add(new Robot("Terminator", "Terminator"));
        tableView.getItems().add(new Robot("Hall9000", "2001: Odisea del Espacio"));
        //3 Añadiendo con AddAll
        tableView.getItems().addAll(new Robot("Data", "Star Trek"), new Robot("Eva", "Ex Machina"));
        //4 Añadiendo directamente al OL
        lista.add(new Robot("TARS","Interestellar"));
        
        //Tabla necesita definir columnas asociadas a las propiedasdes de 1 modelo (Clase)
        //setCellValueFactory indica como se RELACIONAN columnas y datos, es decir, de DÓNDE bebe los datos
        TableColumn<Robot, String> c1 = new TableColumn<>("Nombre");//Título
        c1.setCellValueFactory(new PropertyValueFactory<>("nombre"));//propiedad en modelo Robot
        TableColumn<Robot, String> c2 = new TableColumn<>("Película");//Título
        c2.setCellValueFactory(new PropertyValueFactory<>("peli"));//propiedad en modelo Robot
        tableView.getColumns().addAll(c1, c2);

        //No tiene evento setOnAction...       
        tableView.setOnMouseClicked(e -> {
             //Aunque no es necesario en este caso concreto, para saber si un ListView o TableView 
             //está seleccionado se usa getSelectionModel.isEmpty() : Se suele usar cuando desde otro lugar 
             //(otro botón) queremos comprobar si se ha pinchado en algún elemento
            System.out.println(!tableView.getSelectionModel().isEmpty());
            if (e.getClickCount() == 1) {//1 Click 
                System.out.println("Has hecho click con " + e.getButton());
                Robot robotSelec = (Robot) tableView.getSelectionModel().getSelectedItem();
                if (robotSelec != null) {
                    System.out.println("Robot Seleccionado: " + robotSelec.getNombre()+"\n");
                }
            }
        });

        //Al igual que con el LV, también se puede usar el cambio de property
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, viejoValor, nuevoValor) -> {
            // Manejar el evento de selección aquí
            if (nuevoValor != null) {
                Robot robotSelec = (Robot) nuevoValor;
                System.out.println("Elemento seleccionado por cambio de property: " + robotSelec.getNombre());
            }
        });
        
        //También se podría disparar el evento a partir de un nodo externo, por ejemplo, un botón.
        //En ese caso el TV tendría que tener algo seleccionado y accederíamos mediante
        //.getSelectionModel.getSelectedItem()

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 220, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
