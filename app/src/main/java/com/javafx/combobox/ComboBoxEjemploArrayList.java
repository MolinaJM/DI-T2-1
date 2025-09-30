package com.javafx.combobox;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxEjemploArrayList extends Application {

    ComboBox comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Ejemplo de lo que ocurre cuando intento rellenar un CB con un ArrayList NO observable
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Platano");
        lista.add("Mango");
        lista.add("Kiwi");

        //Si queremos usarlo en el constructor obliga a hacer un casting
        //comboBox = new ComboBox((ObservableList) lista);
        //pero eso no es lo que queremos en este ejemplo
        comboBox = new ComboBox();
        
        System.out.println("Lista de frutas:");
        for (String fruta : lista) {
            System.out.println(fruta);
            comboBox.getItems().add(fruta); //Añado
        }
        // Si modificamos la lista
        lista.add("SANDÍA NO SALE HASTA QUE NO RECARGO");
        
        //Limpio y recargo
        comboBox.getItems().clear();
        System.out.println("Lista de frutas:");
        for (String fruta : lista) {
            System.out.println(fruta);
            comboBox.getItems().add(fruta); //Añado
        }
        //Por eso se usan OL, un cambio en dicha lista recarga el combo ya que está directamente asociado
      
        //Layout Principal
        VBox vbox = new VBox(comboBox);

        vbox.setPadding(new Insets(20));
        Scene scene = new Scene(vbox, 300, 550);
        primaryStage.setTitle("Componentes Básicos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
