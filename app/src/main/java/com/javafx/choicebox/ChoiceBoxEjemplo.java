package com.javafx.choicebox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ChoiceBoxEjemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //ChoiceBox es un ComboBox pero más limitado, no es tan personalizable
        //ComboBox se podría programar para funcionar con Autocompletado
        ChoiceBox choiceBox=new ChoiceBox();

        choiceBox.getItems().add("Piedra");
        choiceBox.getItems().add("Papel");
        choiceBox.getItems().add("Tijeras");
        
        choiceBox.setOnAction((event) -> {
            int selectedIndex=choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem=choiceBox.getSelectionModel().getSelectedItem();

            System.out.println("Juegas con: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   Valor: " + choiceBox.getValue());
        });

        VBox vbox=new VBox(choiceBox);
        Scene scene=new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Ejemplo ChoiceBox");
        primaryStage.show();
    }

}
