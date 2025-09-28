package com.javafx.contenedores;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contenedores extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de Diseños en JavaFX: VBOX,HBOX,GRIDPANE,BORDERPANE Y STACKPANE");
      
        // VBox
        VBox vbox=new VBox(10); // Espaciado vertical de 10 pixels
        Button button1=new Button("Botón 1");
        Button button2=new Button("Botón 2");
        vbox.getChildren().addAll(button1, button2);
        vbox.setStyle("-fx-background-color: black;");

        // HBox
        HBox hbox=new HBox(10); // Espaciado horizontal de 10 pixels
        Button button3=new Button("Botón 3");
        Button button4=new Button("Botón 4");
        hbox.getChildren().addAll(button3, button4);
        hbox.setStyle("-fx-background-color: white;");

        // GridPane
        GridPane gridPane=new GridPane();
        Button button5=new Button("Botón 05");
        Button button6=new Button("Botón 06");
        Button button10=new Button("Botón 10");
        Button button11=new Button("Botón 11");
        GridPane.setConstraints(button5, 0, 0); // Columna 0, Fila 0
        GridPane.setConstraints(button6, 1, 0); // Columna 1, Fila 0
        GridPane.setConstraints(button10, 0, 1); // Columna 0, Fila 1
        GridPane.setConstraints(button11, 1, 1); // Columna 1, Fila 1

        gridPane.getChildren().addAll(button5, button6, button10, button11);
        gridPane.setStyle("-fx-background-color: green;");

        // BorderPane
        BorderPane borderPane=new BorderPane();
        Button button7=new Button("Botón 7");
        Button button8=new Button("Botón 8");
        Button button9=new Button("Botón 9");
        Button button12=new Button("Botón 12");
        Button button13=new Button("Botón 13");
        borderPane.setTop(button7);
        borderPane.setCenter(button8);
        borderPane.setBottom(button9);
        borderPane.setRight(button12);
        borderPane.setLeft(button13);
        borderPane.setStyle("-fx-background-color: blue;");
        
         // StackPane (CAPAS)
        StackPane stackPane=new StackPane();
        Button button14=new Button("Botón 14");
        Button button15=new Button("Botón 15");
        Button button16=new Button("Botón 16");
        stackPane.setStyle("-fx-background-color: red;");
        stackPane.getChildren().addAll(button14, button15, button16);

        // Organizar todo en un VBox principal
        VBox root=new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(vbox, hbox, gridPane, borderPane, stackPane);
        

        Scene scene=new Scene(root, 650, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
