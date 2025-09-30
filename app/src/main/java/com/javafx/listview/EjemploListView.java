package com.javafx.listview; //Modificar al package correcto

import java.util.Comparator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Plantilla JAVAFX
 */
public class EjemploListView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList<String> seriesLista = FXCollections.observableArrayList(
                "Breaking Bad",
                "The Expanse",
                "Stranger Things",
                "Last Of Us",
                "The Mandalorian",
                "Friends",
                "The IT"
        );

        //Se crea el ListView y se le pasa el OL (Fuente)
        ListView<String> lvSeries = new ListView<>(seriesLista);
        VBox vbox = new VBox(lvSeries);
        
        //La OL se modifica y no es necesario decirle nada al ListView para que recargue
        seriesLista.add("The Continental");
        seriesLista.remove(5);
        //seriesLista<.clear(); //Limpia el OL y por consiguiente el LV
        System.out.println("Hay " + seriesLista.size() + " elementos en la lista");
        lvSeries.getItems().sort(Comparator.naturalOrder()); //Orden natural es alfabético ascendente

        //Ocurre lo mismo que con los togglegroup: no sabes el número de elementos, no puedes poner u
        //setOnAction para cada uno, por lo tanto hay que "escuchar" un cambio de alguna propiedad
        lvSeries.getSelectionModel().selectedItemProperty().addListener((observable, viejoValor, nuevoValor) -> {
            // Manejar el evento de selección aquí
            if (nuevoValor != null) {
                System.out.println("Elemento seleccionado: " + nuevoValor);
            }
        });
        
        //Qué pasa si es otro componente el que me interesa que dispare el evento?
        //En este caso es el propio lvSeries, pero podría ser un botón sin problemas y 
        //entonces utilizar .getSelectedItem
        //Pero en este caso lo estamo haciendo todo en el mismo paso
        lvSeries.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1) {//1 Click
                String serie=lvSeries.getSelectionModel().getSelectedItem();
                if (serie != null) {
                    System.out.println("Otra forma: " + serie);
                }
            }
        });
        
        //También se podría disparar el evento a partir de un nodo externo, por ejemplo, un botón.
        //En ese caso el LV tendría que tener algo seleccionado y accederíamos mediante
        //.getSelectionModel.getSelectedItem()

        // Permite PERSONALIZAR entre otras cosas como se pinta (renderiza) los elementos: puede cambiar el texto o el aspecto
        // En este caso le estamos diciendo cómo actualizar un Item
        // setCellFactory indica CÓMO se muestran esos datos. 
        // El "problema" es que cada Nodo tiene su forma peculiar de personalización, en el caso
        // del TV es similar, creando un new TableCell<Modelo,tipo> y recargando el método updateItem
        lvSeries.setCellFactory(e -> new ListCell<String>() {
            @Override
            //Se ejecuta cada vez que muestra un Item.
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    this.setText(item);
                    //Inicio parte personalizable
                    if (item.equals("The Expanse")) {//Personalizamos
                        this.setText(item+" (Favorita)");
                        this.setStyle("-fx-background-color: lightblue; -fx-font-weight: bold;"); //CSS
                    }
                    else{
                        this.setStyle(null);
                    }
                    //Fin parte personalizable
                } else {
                    setText(null);
                }
            }
        });

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Lista de Series");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
//Otras cosas que permite el .setCellFactory:
// reordenar elementos: para ello habría que tocar los eventos .setOnDragDetected, .setOnDragOver y .setOnDragDropped