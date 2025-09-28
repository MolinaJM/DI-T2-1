package com.javafx.combobox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ComboBoxEjemplo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ComboBox comboBox=new ComboBox();

        comboBox.getItems().add("Piedra");
        comboBox.getItems().add("Papel");
        comboBox.getItems().add("Tijeras");

        comboBox.setEditable(true);

        comboBox.setOnAction((event) -> {
            int selectedIndex=comboBox.getSelectionModel().getSelectedIndex();
            Object selectedItem=comboBox.getSelectionModel().getSelectedItem();

            System.out.println("Juegas con: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   Valor: " + comboBox.getValue());
        });

        VBox vbox=new VBox(comboBox);
        Scene scene=new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setTitle("Ejemplo ComboBox ");
        primaryStage.show();
    }

}
